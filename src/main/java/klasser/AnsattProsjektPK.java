package klasser;

@SuppressWarnings("unused")
public class AnsattProsjektPK {

    private int ansatt;
    private int prosjekt;

    public AnsattProsjektPK() {
    }

    public AnsattProsjektPK(int ansattId, int prosjektId) {
        this.ansatt = ansattId;
        this.prosjekt = prosjektId;
    }
}
