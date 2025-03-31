package Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "oblig3")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektId;

    private String prosjektNavn;
    private String beskrivelse;

    @OneToMany(mappedBy = "prosjekt")
    private List<AnsattProsjekt> ansattProsjekt;


    public Prosjekt() {}

    public Prosjekt (String prosjektNavn, String beskrivelse) {
        this.prosjektNavn = prosjektNavn;
        this.beskrivelse = beskrivelse;
    }

    public void leggTilAnsattProsjekt(AnsattProsjekt ansattprosjekt) {
        ansattProsjekt.add(ansattprosjekt);
    }
    public void fjernTilAnsattProsjekt(AnsattProsjekt ansattprosjekt) {
        ansattProsjekt.remove(ansattprosjekt);
    }

    public int getProsjektId() {
        return prosjektId;
    }
    public String getProsjektNavn() {
        return prosjektNavn;
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }
    public List<AnsattProsjekt> getAnsattProsjekt() {
        return ansattProsjekt;
    }
    public void skrivUt(String innrykk) {
        System.out.printf("%sProsjekt nr %d: %s: %s", innrykk, prosjektId, prosjektNavn, beskrivelse);
    }

    public void skrivUtMedAnsatte() {
        System.out.println();
        skrivUt("");
        ansattProsjekt.forEach(a -> a.skrivUt("\n   "));
    }

}
