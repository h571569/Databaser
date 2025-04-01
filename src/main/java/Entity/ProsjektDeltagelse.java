package Entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "oblig3")
public class ProsjektDeltagelse {

    private int timer = 0;

    @Id
    @ManyToOne
    @JoinColumn(name = "prosjektid")
    private Prosjekt prosjekt;

    @Id
    @ManyToOne
    @JoinColumn(name = "ansattid")
    private Ansatt ansatt;

    public ProsjektDeltagelse() {}

    public ProsjektDeltagelse(Prosjekt prosjekt, Ansatt ansatt, int timer) {
        this.prosjekt = prosjekt;
        this.ansatt = ansatt;
        this.timer = timer;
//        ansatt.leggTilAnsattProsjekt(this);
        prosjekt.leggTilAnsattProsjekt(this);
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk,
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getProsjektNavn(), timer);
    }
}
