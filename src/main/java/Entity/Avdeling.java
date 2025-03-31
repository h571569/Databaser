package Entity;

import jakarta.persistence.*;

import java.util.List;

@Table(schema = "oblig3")
@Entity
public class Avdeling {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avdelingId;

    private String avdelingNavn;

    @OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
    private List<Ansatt> ansatte;

    public Avdeling() {}

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }
    public void  leggTilAnsatte(Ansatt ansatt){
        ansatte.add(ansatt);
    }
    public void  fjernAnsatte(Ansatt ansatt){
        ansatte.remove(ansatt);
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
