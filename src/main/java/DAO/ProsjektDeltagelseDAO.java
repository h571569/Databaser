package DAO;

import Entity.Prosjekt;
import Entity.ProsjektDeltagelse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.security.PublicKey;

public class ProsjektDeltagelseDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPCU");


    public ProsjektDeltagelse finnProsjektDeltagelseMedAnsattId(int ansattId) {
        EntityManager em = emf.createEntityManager();
        String queryString = "select k from ProsjektDeltagelse k where k.ansattId = :ansattId";

        try{
            TypedQuery<ProsjektDeltagelse> query = em.createQuery(queryString, ProsjektDeltagelse.class);
            query.setParameter("ansattId", ansattId);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public void leggTilAnsattTilProsjekt(int prosjektId, int  ansattId, String rolle) {

    }

    public void leggTilTimerForAnsatt(int prosjektId, int  ansattId) {

    }

    public int antallTimerForProsjekt(int prosjektId, int  ansattId) {
        return 0;
    }

    public int timerPerProsjekt(int prosjektId, int  ansattId) {
        return 0;
    }

    //Det skal ikke være mulig å slette en ansatt  om han har registrert timer i prosjektet
    public void  slettAnsattFraProsjekt(int prosjektId, int  ansattId) {

    }



}

