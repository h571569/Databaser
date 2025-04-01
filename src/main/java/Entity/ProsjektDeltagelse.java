package Entity;

import jakarta.persistence.*;

import java.security.PublicKey;

@Entity
@Table(schema = "oblig3", name = "prosjektDeltagelse")
@IdClass(ProsjektDeltagelsePK.class)
public class ProsjektDeltagelse {

    private int arbeidstimer;
    private String rolle;


    @Id
    @ManyToOne
    @JoinColumn(name = "prosjektid")
    private Prosjekt prosjekt;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ansattid")
    private Ansatt ansatt;

    public ProsjektDeltagelse() {}

    public int getArbeidstimer() {
        return arbeidstimer;
    }

    public void setArbeidstimer(int arbeidstimer) {
        this.arbeidstimer = arbeidstimer;
    }

    public String getRolle() {
        return rolle;
    }
    public Prosjekt getProsjekt() {
        return prosjekt;
    }
    public void setProsjekt(Prosjekt prosjekt) {
        this.prosjekt = prosjekt;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
    public Ansatt getAnsatt() {
        return ansatt;
    }
    public void setAnsatt(Ansatt ansatt) {
        this.ansatt = ansatt;
    }


    public ProsjektDeltagelse(Ansatt ansatt, Prosjekt prosjekt, String rolle) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.rolle = rolle;
        arbeidstimer  = 0;
        ansatt.leggTilAnsattProsjekt(this);
        prosjekt.leggTilAnsattProsjekt(this);
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: Navn: %s %s, ProsjektID: %d - %s, Rolle: %s, %d timer", innrykk,
                ansatt.getFornavn(), ansatt.getEtternavn(),  prosjekt.getProsjektId(), prosjekt.getProsjektNavn(), rolle, this.getArbeidstimer());
    }
}
