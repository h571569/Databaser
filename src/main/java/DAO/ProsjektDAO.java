package DAO;

import Entity.Prosjekt;

public class ProsjektDAO {

    public void slettProsjektMedId(int prosjektId) {

        //Det skal ikke være mulig å slett ett prosjekt om det er registrert timer i prosjektet
    }

    public void leggTilProsjekt(String prosjektNavn, String beskrivelse) {

    }

    public Prosjekt finnProsjektMedId(int prosjektId) {
        return null;
    }
    public Prosjekt finnProsjektMedProsjektNavn(String prosjektNavn) {
        return null;
    }
    public void hentAlleProsjekter(){}

}
