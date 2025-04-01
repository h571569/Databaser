package DAO;

import jakarta.persistence.*;
import Entity.Ansatt;

import java.time.LocalDate;
import java.util.List;

public class AnsattDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPCU");


    public Ansatt finnAnsattMedId(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }

    public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
        EntityManager em = emf.createEntityManager();
        String queryString =  """
                                 select t from Ansatt t where
                                 t.brukernavn = :brukernavn""";

        try {
            TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
            query.setParameter("brukernavn", brukernavn);
            return query.getSingleResult();

        } finally {
            em.close();
        }
    }

    public void hentAlleAnsatte() {
        EntityManager em = emf.createEntityManager();
        String queryString = "select a from Ansatt a";

        try {
            TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
            List<Ansatt> ansatte = query.getResultList();

            for (Ansatt ansatt : ansatte) {
                System.out.println(ansatt);
            }

        } finally {
            em.close();
        }
    }

    public void oppdaterAnsattStilling(int ansattId,  String stilling) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Ansatt ansatt = em.find(Ansatt.class, ansattId);
            if(ansatt != null) {
                ansatt.setStilling(stilling);
            } else {
                System.out.println("Ansatt " + ansattId + " ikke funnet i databasen");
            }
            tx.commit();
        } catch  (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        }  finally {
            em.close();
        }
    }
    public void oppdaterAnsattLonn(int ansattId,  int manedsLonn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Ansatt ansatt = em.find(Ansatt.class, ansattId);
            if(ansatt != null) {
                ansatt.setManedslonn(manedsLonn);
            } else {
                System.out.println("Ansatt " + ansattId + " ikke funnet i databasen");
            }
            tx.commit();
        } catch  (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        }  finally {
            em.close();
        }
    }

    public void leggTilAnsatt(String brukernavn, String fornavn, String etternavn, LocalDate ansDato, String stilling, int manedslonn){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Ansatt ansatt = new Ansatt(brukernavn,fornavn,etternavn,ansDato,stilling,manedslonn);
            em.persist(ansatt);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }


}
