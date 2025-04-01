package DAO;

import Entity.Prosjekt;
import jakarta.persistence.*;

import java.util.List;

public class ProsjektDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPCU");


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
        } finally {
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


//    public void skrivUtAlleProsjekter() {
//        // Lag EntityManager
//        EntityManager em = emf.createEntityManager(); // emf er din EntityManagerFactory
//
//        // Lag JPQL-spørring for å hente alle prosjekter
//        String queryString = "SELECT p FROM Prosjekt p"; // Henter alle Prosjekt-objekter
//        TypedQuery<Prosjekt> query = em.createQuery(queryString, Prosjekt.class);
//
//        try {
//            // Utfør spørringen og hent resultatene
//            List<Prosjekt> prosjekter = query.getResultList();
//
//            // Skriv ut alle prosjektene
//            for (Prosjekt prosjekt : prosjekter) {
//                prosjekt.skrivUt(""); // Forutsetter at Prosjekt har en skrivUt-metode
//            }
//        } finally {
//            em.close(); // Husk å lukke EntityManager
//        }
//    }

}
