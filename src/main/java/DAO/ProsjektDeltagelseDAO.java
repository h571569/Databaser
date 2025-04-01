package DAO;

import Entity.Ansatt;
import Entity.Prosjekt;
import Entity.ProsjektDeltagelse;

import jakarta.persistence.*;

import java.security.PublicKey;
import java.util.List;

public class ProsjektDeltagelseDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPCU");



    public void leggTilTimerForAnsatt(int prosjektid, int ansattid, int arbeidstimer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        String  queryString = """
                          select k from ProsjektDeltagelse as k where
                          k.ansatt.ansattid = :ansattid and
                          k.prosjekt.prosjektid = :prosjektid""";

        try {
            tx.begin();
            TypedQuery<ProsjektDeltagelse> query = em.createQuery(queryString, ProsjektDeltagelse.class);
            query.setParameter("ansattid", ansattid);
            query.setParameter("prosjektid", prosjektid);

            ProsjektDeltagelse p = query.getSingleResult();
            if(p == null) {
                System.out.println(ansattid  + " Har ikke deltatt i noen prosjekter");
                return;
            }

            p.setArbeidstimer(p.getArbeidstimer() + arbeidstimer);
            em.merge(p);
            em.flush();
            tx.commit();
            System.out.println(arbeidstimer + " Ble lagt til for");
        }  catch (Throwable e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

    public void registrerProsjektDeltagelse(int prosjektid, int ansattid, String rolle) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        String  queryString = """
                          select k from ProsjektDeltagelse as k where
                          k.ansatt.ansattid = :ansattid and
                          k.prosjekt.prosjektid = :prosjektid""";

        try {
            tx.begin();
            TypedQuery<ProsjektDeltagelse> query = em.createQuery(queryString, ProsjektDeltagelse.class);
            query.setParameter("ansattid", ansattid);
            query.setParameter("prosjektid", prosjektid);

            List<ProsjektDeltagelse> list = query.getResultList();
            if(!list.isEmpty()) {
                System.out.println("Ansatt er allerede tilknyttet prosjektet");
                return;
            }

            Prosjekt prosjekt = em.find(Prosjekt.class, prosjektid);
            if(prosjekt == null) {
                System.out.println("Prosjektet finnes ikke");
                return;
            }
            Ansatt ansatt =  em.find(Ansatt.class, ansattid);
            if(ansatt == null) {
                System.out.println("Ansatt finnes ikke");
                return;
            }

            ProsjektDeltagelse p = new ProsjektDeltagelse(ansatt,prosjekt,rolle);
            em.persist(p);
            em.flush();
            tx.commit();

        }catch (Throwable e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

    // Jeg fikk ikke tid til denne

    //Det skal ikke være mulig å slette en ansatt  om han har registrert timer i prosjektet
    public void  slettAnsattFraProsjekt(int prosjektId, int  ansattId) {

    }



}

