package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import klasser.Avdeling;

import java.security.PublicKey;

public class AvdelingDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPCU");

    public Avdeling finnAvdelingMedId(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Avdeling.class, id);
        } finally {
            em.close();
        }

    }
}
