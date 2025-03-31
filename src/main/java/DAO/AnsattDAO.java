package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import klasser.Ansatt;

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

    public void leggTilAnsatt() {

    }


}
