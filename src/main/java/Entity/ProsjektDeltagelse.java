package Entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "oblig3")
public class ProsjektDeltagelse {

    private int timer = 0;
    private  String rolle;

    @Id
    @ManyToOne
    @JoinColumn(name = "prosjektid")
    private Prosjekt prosjekt;

    @Id
    @ManyToOne
    @JoinColumn(name = "ansattid")
    private Ansatt ansatt;

    public ProsjektDeltagelse() {}

    public ProsjektDeltagelse(Prosjekt prosjekt, Ansatt ansatt, int timer, String rolle) {
        this.prosjekt = prosjekt;
        this.ansatt = ansatt;
        this.timer = timer;
        this.rolle= rolle;
        ansatt.leggTilAnsattProsjekt(this);
        prosjekt.leggTilAnsattProsjekt(this);
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
    public int getTimer() {
        return timer;
    }
    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
    public String getRolle() {
        return rolle;
    }
    public Ansatt getAnsatt() {
        return ansatt;
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk,
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getProsjektNavn(), timer);
    }
}
