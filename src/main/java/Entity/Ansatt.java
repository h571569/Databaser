package Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Table(schema = "oblig3")
@Entity
public class Ansatt {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattId;

    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private LocalDate ansDato;
    private String stilling;
    private int manedslonn;

    @ManyToOne
    @JoinColumn(name = "avdelingId")
    private Avdeling avdeling;


    @OneToOne(mappedBy = "sjef")
    private Avdeling sjef;

//    @OneToMany(mappedBy = "prosjekt",fetch = FetchType.EAGER)
//    private List<ProsjektDeltagelse> deltagelser;

    public Ansatt(){}

    public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansDato, String stilling, int manedslonn) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.ansDato = ansDato;
        this.stilling = stilling;
        this.manedslonn = manedslonn;
    }
//
//    public void leggTilAnsattProsjekt(ProsjektDeltagelse prosjektDeltagelse) {
//        deltagelser.add(prosjektDeltagelse);
//
//    }
//    public void fjernTilAnsattProsjekt(ProsjektDeltagelse prosjektDeltagelse) {
//        deltagelser.remove(prosjektDeltagelse);
//    }
//
//    public List<ProsjektDeltagelse> getProsjektDeltagelse() {
//        return deltagelser;
//    }

    public void setAvdeling(Avdeling avdeling) {
        this.avdeling = avdeling;
    }

    public Avdeling getAvdeling() {
        return avdeling;
    }

    public String getFornavn() {
        return fornavn;
    }

    public int getAnsattId() {
        return ansattId;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public LocalDate getAnsDato() {
        return ansDato;
    }

    public String getStilling() {
        return stilling;
    }
    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getManedslonn() {
        return manedslonn;
    }
    public void setManedslonn(int manedslonn) {
        this.manedslonn = manedslonn;
    }





    @Override
    public String toString() {
        return "Ansatt nr " + ansattId +
                " [ brukernavn = " + brukernavn +
                ", fornavn = " + fornavn +
                ", etternavn = " + etternavn +
                ", ansDato = " + ansDato +
                ", stilling = " + stilling +
                ", månedslonn = " + manedslonn +
                ", avdeling = " + avdeling.getAvdelingId() +
                " ]";
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sAnsatt nr %d: %s %s %s %s %s %d %d", innrykk, ansattId, brukernavn, fornavn, etternavn, ansDato, stilling, manedslonn, avdeling.getAvdelingId());
    }

    public void skrivUtMedProsjekter() {
        System.out.println();
        skrivUt("");
//        deltagelser.forEach(p -> p.skrivUt("\n   "));
    }
}
