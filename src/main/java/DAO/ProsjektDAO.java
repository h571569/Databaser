package DAO;

import Entity.Prosjekt;
import Entity.ProsjektDeltagelse;
import Entity.Ansatt;
import jakarta.persistence.*;


import java.security.PublicKey;
import java.util.List;

public class ProsjektDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPCU");

    //  Fikk ikke tid til denne
    public void slettProsjektMedId(int prosjektId) {

        //Det skal ikke være mulig å slett ett prosjekt om det er registrert timer i prosjektet
    }

    public void leggTilProsjekt(String prosjektNavn, String beskrivelse) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Prosjekt prosjekt = new Prosjekt(prosjektNavn, beskrivelse);
            Prosjekt p1 = finnProsjektMedProsjektNavn(prosjektNavn);
            if (p1 != null) {
                System.out.println("Prosjekt finnes allerede i databasen");
                return;
            }
            em.persist(prosjekt);
            tx.commit();
            System.out.println("Prosjektet " + prosjektNavn + " ble lagt til");
        } catch (Throwable t) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

    public Prosjekt finnProsjektMedId(int prosjektId) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Prosjekt.class, prosjektId);
        } catch (NoResultException e) {
            System.out.println("Fant ikke prosjekt");
            return null;
        }
        finally {
            em.close();
        }
    }


    public Prosjekt finnProsjektMedProsjektNavn(String prosjektNavn) {
        EntityManager em = emf.createEntityManager();
        String queryString = "select p from Prosjekt p where p.prosjektNavn = :prosjektNavn";

        try {
            TypedQuery<Prosjekt> query = em.createQuery(queryString, Prosjekt.class);
            query.setParameter("prosjektNavn", prosjektNavn);
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Fant ikke prosjekt");
            return null;
        } finally {
            em.close();
        }
    }
    public void hentAlleProsjekter(){
        EntityManager em = emf.createEntityManager();
        String queryString = "select p from Prosjekt p";

        try{
            TypedQuery<Prosjekt> query = em.createQuery(queryString, Prosjekt.class);
            List<Prosjekt> prosjektList = query.getResultList();

            for (Prosjekt p : prosjektList) {
                System.out.println(p.getProsjektNavn());
            }
        } finally {
            em.close();
        }
    }

    public void skrivUtProsjektInfo(int prosjektId) {
        EntityManager em = emf.createEntityManager();
        String queryString = """
                select p from Prosjekt as p
                left join fetch p.deltagelser as d
                left join fetch d.ansatt
                where p.prosjektid = :prosjektid
                """;

        try {
            TypedQuery<Prosjekt> query = em.createQuery(queryString, Prosjekt.class);
            query.setParameter("prosjektid", prosjektId);
            try {
                Prosjekt prosjekt = query.getSingleResult();

                System.out.println("Prosjekt: " + prosjekt.getProsjektNavn());
                System.out.println("Prosjektbeskrivelse: " +  prosjekt.getBeskrivelse());
                System.out.println("Ansatte i prosjektet: ");

                int totalTimer= 0;

                for (ProsjektDeltagelse deltagelse : prosjekt.getAnsattProsjekt())  {
                    Ansatt ansatt = deltagelse.getAnsatt();
                    String  rolle = deltagelse.getRolle();
                    int arbeidstimer = deltagelse.getArbeidstimer();
                    totalTimer += deltagelse.getArbeidstimer();

                    System.out.println("Ansatt: " + ansatt.getFornavn() + " " + ansatt.getEtternavn() +
                            " Rolle: " + rolle + " Arbeidstimer: " + arbeidstimer);

                }
                System.out.println("Total timer for prosjektet: " + totalTimer);

            } catch (NoResultException e) {
                System.out.println("Prosjektet finnes ikke");
            }

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            em.close();
        }
    }

}
