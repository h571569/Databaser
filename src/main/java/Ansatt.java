import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table(schema = "oblig3")
@Entity
public class Ansatt {


    @Id private int ansattId;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private Date ansDato;
    private String stilling;
    private int manedslonn;

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

    @Override
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

}
