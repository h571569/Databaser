package Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(schema = "oblig3")
@Entity
public class Avdeling {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avdelingId;

    private String avdelingNavn;

    @OneToOne
    @JoinColumn(name = "sjefId")
    private Ansatt sjef;


    @OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
    private List<Ansatt> ansatte;

    public Avdeling() {}

    public Avdeling(String avdelingNavn) {
        this.avdelingNavn = avdelingNavn;
        ansatte =  new ArrayList<Ansatt>();
    }

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }
    public void  leggTilAnsatte(Ansatt ansatt){
        ansatte.add(ansatt);
        ansatt.setAvdeling(this);
    }
    public void  fjernAnsatte(Ansatt ansatt){
        ansatte.remove(ansatt);
        ansatt.setAvdeling(null);
    }
    public Ansatt getSjef() {
        return sjef;
    }
    public int getAvdelingId() {
        return avdelingId;
    }
    public String getAvdelingNavn() {
        return avdelingNavn;
    }





    public void skrivUt(String innrykk) {
        System.out.printf("%sAvdeling nr %d: %s", innrykk, avdelingId, avdelingNavn);

    }

    public void skrivUtMedAnsatte() {
        System.out.println();
        skrivUt("");
        ansatte.forEach(a -> a.skrivUt("\n   "));
    }
}
