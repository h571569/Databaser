package Entity;

@SuppressWarnings("unused")
public class ProsjektDeltagelsePK {

    private int ansatt;
    private int prosjekt;

    public ProsjektDeltagelsePK() {
    }

    public ProsjektDeltagelsePK(int ansattId, int prosjektId) {
        this.ansatt = ansattId;
        this.prosjekt = prosjektId;
    }
}
