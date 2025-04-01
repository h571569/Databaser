package DAO;

import Entity.Prosjekt;

import java.security.PublicKey;

public class ProsjektDeltagelseDAO {

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

