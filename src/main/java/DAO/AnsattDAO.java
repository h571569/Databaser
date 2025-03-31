package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Entity.Ansatt;

import java.util.Date;

public class AnsattDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPCU");


    public Ansatt finnAnsattMedId(int id) {

        System.out.println("Kobler til database...");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }

    public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, brukernavn);

        } finally {
            em.close();
        }
    }

    public void hentAlleAnsatte() {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

        } finally {
            em.close();
        }
    }

    public void oppdaterAnsattStilling() {

    }

    public void leggTilAnsatt(String brukernavn, String fornavn, String etternavn, Date ansDato, String stilling, int manedslonn){
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
