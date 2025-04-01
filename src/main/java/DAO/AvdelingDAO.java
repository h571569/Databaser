package DAO;

import Entity.Ansatt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Entity.Avdeling;

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

    public void leggTilNyAvdeling(String avdelingNavn, int nySjefId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Ansatt ansatt = em.find(Ansatt.class, nySjefId);
            if (ansatt == null) {
                System.out.print("Ansatt med ansattId " + nySjefId +  " finnes ikke");
                return;
            }

            Avdeling avdeling = ansatt.getAvdeling();

            if(avdeling != null && avdeling.getSjef() != null && avdeling.getSjef().getAnsattId() == nySjefId) {
                System.out.println("Ansatt er sjef i avdeling " + avdeling.getAvdelingId() + " Ansatt kan ikke bli sjef i ny avdeling");
                return;
            }
            if(avdeling != null) {
                avdeling.fjernAnsatt(ansatt);
            }
            Avdeling nyAvdeling = new Avdeling(avdelingNavn, ansatt);
            ansatt.setAvdeling(nyAvdeling);
            em.persist(nyAvdeling);
            em.merge(ansatt);
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

    public void  slettAvdelingMedId(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Avdeling avdeling = em.find(Avdeling.class, id);
            if(avdeling == null) {
                System.out.println("Avdeling finnes ikke i databasen");
                return;
            }
            if(!avdeling.getAnsatte().isEmpty()) {
                System.out.println("Det er ansatte i avdelingen, avdelingen kan ikke slettes med ansatte som fortsatt jobber der");
                return;
            }
            em.remove(avdeling);

            tx.commit();


        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        }finally {
            em.close();
        }
    }
}
