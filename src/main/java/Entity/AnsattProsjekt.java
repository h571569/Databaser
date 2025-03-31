package Entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "oblig3")
public class AnsattProsjekt {

    private int timer = 0;

    @Id
    @ManyToOne
    @JoinColumn(name = "prosjektid")
    private Prosjekt prosjekt;

    @Id
    @ManyToOne
    @JoinColumn(name = "ansattid")
    private Ansatt ansatt;

    public AnsattProsjekt() {}

    public AnsattProsjekt(Prosjekt prosjekt, Ansatt ansatt) {
        this.prosjekt = prosjekt;
        this.ansatt = ansatt;
        ansatt.leggTilAnsattProsjekt(this);
        prosjekt.leggTilAnsattProsjekt(this);
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk,
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getProsjektNavn(), timer);
    }
}
