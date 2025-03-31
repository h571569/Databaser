package Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(schema = "oblig3")
@Entity
public class Ansatt {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattId;

    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private Date ansDato;
    private String stilling;
    private int manedslonn;

    @ManyToOne
    @JoinColumn(name = "avdelingId")
    private Avdeling avdeling;

    // Vet ikke om denne skal være her eller i avdeling
    @OneToOne(mappedBy = "sjef")
    private Avdeling sjef;

    @OneToMany(mappedBy = "prosjekt")
    private List<AnsattProsjekt> ansattProsjekt;

    public Ansatt(){}

    public Ansatt(String brukernavn, String fornavn, String etternavn, Date ansDato, String stilling, int manedslonn) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.ansDato = ansDato;
        this.stilling = stilling;
        this.manedslonn = manedslonn;
    }

    public void leggTilAnsattProsjekt(AnsattProsjekt ansattprosjekt) {
        ansattProsjekt.add(ansattprosjekt);
    }
    public void fjernTilAnsattProsjekt(AnsattProsjekt ansattprosjekt) {
        ansattProsjekt.remove(ansattprosjekt);
    }

    public List<AnsattProsjekt> getAnsattProsjekt() {
        return ansattProsjekt;
    }

    public Avdeling getAvdeling() {
        return avdeling;
    }
    public void setAvdeling(Avdeling avdeling) {
        this.avdeling = avdeling;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public int getAnsattId() {
        return ansattId;
    }
    public void setAnsattId(int ansattId) {
        this.ansattId = ansattId;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public Date getAnsDato() {
        return ansDato;
    }

    public void setAnsDato(Date ansDato) {
        this.ansDato = ansDato;
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

    
    public String toString() {
        return "Ansatt{" +
                "ansattId=" + ansattId +
                ", brukernavn='" + brukernavn + '\'' +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", ansDato=" + ansDato +
                ", stilling='" + stilling + '\'' +
                ", manedslonn=" + manedslonn +
                '}';
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sAnsatt nr %s: %s %s %s %s %s", innrykk, brukernavn, fornavn, etternavn, ansDato, stilling, manedslonn);
    }

    public void skrivUtMedProsjekter() {
        System.out.println();
        skrivUt("");
        ansattProsjekt.forEach(p -> p.skrivUt("\n   "));
    }
}
