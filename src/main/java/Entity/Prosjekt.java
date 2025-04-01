package Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "oblig3", name = "prosjekt")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektid;

    private String prosjektNavn;
    private String beskrivelse;

    @OneToMany(mappedBy = "prosjekt")
    private List<ProsjektDeltagelse> deltagelser = new ArrayList<>();


    public Prosjekt() {}

    public Prosjekt (String prosjektNavn, String beskrivelse) {
        this.prosjektNavn = prosjektNavn;
        this.beskrivelse = beskrivelse;
    }

    public void leggTilAnsattProsjekt(ProsjektDeltagelse prosjektDeltagelse) {
        deltagelser.add(prosjektDeltagelse);
    }
    public void fjernTilAnsattProsjekt(ProsjektDeltagelse prosjektDeltagelse) {
        deltagelser.remove(prosjektDeltagelse);
    }

    public int getProsjektId() {
        return prosjektid;
    }
    public String getProsjektNavn() {
        return prosjektNavn;
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }
    public List<ProsjektDeltagelse> getAnsattProsjekt() {
        return deltagelser;
    }
    public void skrivUt(String innrykk) {
        System.out.printf("%sProsjekt nr %d: %s: %s", innrykk, prosjektid, prosjektNavn, beskrivelse);
    }

    public void skrivUtMedAnsatte() {
        System.out.println();
        skrivUt("");
        deltagelser.forEach(a -> a.skrivUt("\n   "));
    }

}
