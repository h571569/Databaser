
import DAO.AnsattDAO;
import DAO.AvdelingDAO;
import DAO.ProsjektDAO;
import DAO.ProsjektDeltagelseDAO;
import Entity.Ansatt;
import Entity.Avdeling;
import Entity.Prosjekt;
import org.hibernate.type.descriptor.sql.internal.Scale6IntervalSecondDdlType;


import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class MainMeny {
    public static void main(String[] args) {


        AnsattDAO  ansattDAO = new AnsattDAO();
        AvdelingDAO avdelingDAO = new AvdelingDAO();
        ProsjektDAO prosjektDAO = new ProsjektDAO();
        ProsjektDeltagelseDAO prosjektDeltagelseDAO = new ProsjektDeltagelseDAO();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n\nVelkommen til Dat107 - Oblig 3 Vennligst velg en handling:");
            System.out.println("1. Finne en ansatt med ansattId");
            System.out.println("2. Finne en ansatt med brukernavn");
            System.out.println("3. Hente ut alle ansatte");
            System.out.println("4. Oppdatere en ansatt sin stilling");
            System.out.println("5. Oppdatere en ansatt sin lønn");
            System.out.println("6. Legg til en ansatt");
            System.out.println("7. Oppdatere avdeling for en ansatt");
            System.out.println("8. Slette en ansatt med ansattId");
            System.out.println("9. Legge til en ny avdeling");
            System.out.println("10. Finne avdeling med avdelingId");
            System.out.println("11. Slette en avdeling med avdelingId");
            System.out.println("12. Legge til ett prosjekt");
            System.out.println("13. Finne ett prosjekt med prosjektId");
            System.out.println("14. Finne ett prosjekt med prosjektNavn");
            System.out.println("15. Hente ut alle prosjekter");
            System.out.println("16. Skrive ut prosjektinfo fra prosjektid");
            System.out.println("17. Legge til timer for ansatt");
            System.out.println("18. Registrere prosjekt deltagelse");
            System.out.println("0. Avslutte");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Skriv inn ansattid: ");
                    int ansattId = scanner.nextInt();
                    scanner.nextLine();
                    Ansatt ansatt = ansattDAO.finnAnsattMedId(ansattId);
                    if (ansatt != null) {
                        ansatt.skrivUtMedProsjekter();
                    } else {
                        System.out.println("Ingen ansatt funnet med id: " + ansattId);
                    }
                    break;
                }
                case 2: {
                    System.out.print("Skriv inn brukernavn: ");
                    String brukernavn = scanner.nextLine();
                    Ansatt ansatt = ansattDAO.finnAnsattMedBrukernavn(brukernavn);
                    if (ansatt != null) {
                        ansatt.skrivUtMedProsjekter();
                    }
                    break;
                }
                case 3: {
                    System.out.println("Alle ansatte:");
                    ansattDAO.hentAlleAnsatte();
                    break;
                }
                case 4: {
                    System.out.print("Skriv inn ansattid: ");
                    int ansattId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Skriv inn ny stilling: ");
                    String stilling = scanner.nextLine();
                    ansattDAO.oppdaterAnsattStilling(ansattId, stilling);
                    break;
                }
                case 5: {
                    System.out.print("Skriv inn ansattid: ");
                    int ansattId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Skriv inn ny lønn: ");
                    int manedslonn = scanner.nextInt();
                    scanner.nextLine();
                    ansattDAO.oppdaterAnsattLonn(ansattId, manedslonn);
                    break;
                }
                case 6: {
                    System.out.print("Skriv inn brukernavn: ");
                    String brukernavn = scanner.nextLine();
                    System.out.print("Skriv inn fornavn: ");
                    String fornavn = scanner.nextLine();
                    System.out.print("Skriv inn etternavn: ");
                    String etternavn = scanner.nextLine();
                    System.out.print("Skriv inn ansettelsesdato (yyyy-mm-dd): ");
                    String ansDatoStr = scanner.nextLine();
                    LocalDate date = LocalDate.parse(ansDatoStr);
                    System.out.print("Skriv inn Stilling til ansatte: ");
                    String stilling = scanner.nextLine();
                    System.out.print("Skriv inn den ansatte sin månedslønn: ");
                    String manedslonn = scanner.nextLine();
                    int lonn = parseInt(manedslonn);
                    System.out.print("Skriv inn avdelings ID for den ansatte: ");
                    String avdelingsid = scanner.nextLine();
                    int avdID = parseInt(avdelingsid);

                    ansattDAO.leggTilAnsatt(brukernavn, fornavn, etternavn, date, stilling, lonn, avdID);
                    break;
                }
                case 7: {
                    System.out.print("Skriv inn ansattid: ");
                    int ansattId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Skriv inn Ny  avdelingsId: ");
                    int nyAvdelingId = scanner.nextInt();
                    scanner.nextLine();
                    ansattDAO.oppdaterAvdelingForAnsatt(ansattId, nyAvdelingId);
                    break;
                }
                case 8: {
                    System.out.print("Skriv inn ansattid: ");
                    int ansattId = scanner.nextInt();
                    scanner.nextLine();
                    ansattDAO.slettAnsattMedId(ansattId);
                    break;
                }
                case 9: {
                    System.out.print("Skriv inn avdelingsnavn: ");
                    String avdelingNavn = scanner.nextLine();
                    System.out.print("Skriv inn ansatt id som skal bli ny sjef: ");
                    int sjefid = scanner.nextInt();
                    scanner.nextLine();
                    avdelingDAO.leggTilNyAvdeling(avdelingNavn, sjefid);
                    break;
                }
                case 10: {
                    System.out.println("Skriv inn avdelingId");
                    int avdelingId = scanner.nextInt();
                    scanner.nextLine();
                    Avdeling avdeling = avdelingDAO.finnAvdelingMedId(avdelingId);
                    if(avdeling != null) {
                        avdeling.skrivUtMedAnsatte();
                    }
                    break;

                }
                case 11: {
                    System.out.print("Skriv inn avdelingId: ");
                    int avdelingId = scanner.nextInt();
                    scanner.nextLine();
                    avdelingDAO.slettAvdelingMedId(avdelingId);
                    break;
                }
                case 12: {
                    System.out.print("Skriv inn prosjektnavn: ");
                    String prosjektNavn = scanner.nextLine();
                    System.out.print("Skriv inn beskrivelse: ");
                    String beskrivelse = scanner.nextLine();
                    prosjektDAO.leggTilProsjekt(prosjektNavn, beskrivelse);
                    break;
                }
                case 13: {
                    System.out.print("Skriv inn prosjektid: ");
                    int prosjektId = scanner.nextInt();
                    scanner.nextLine();
                    Prosjekt prosjekt = prosjektDAO.finnProsjektMedId(prosjektId);
                    if (prosjekt != null) {
                        System.out.println("Fant prosjekt: " + prosjekt);
                    }
                    break;
                }
                case 14: {
                    System.out.print("Skriv inn prosjektnavn: ");
                    String prosjektNavn = scanner.nextLine();
                    Prosjekt prosjekt = prosjektDAO.finnProsjektMedProsjektNavn(prosjektNavn);
                    if (prosjekt != null) {
                        System.out.println("Fant prosjekt: " + prosjekt);
                    }
                    break;
                }
                case 15: {
                    System.out.println("Alle prosjekter:");
                    prosjektDAO.hentAlleProsjekter();
                    break;
                }
                case 16: {
                    System.out.print("Skriv inn prosjektid: ");
                    int prosjektId = scanner.nextInt();
                    scanner.nextLine();
                    prosjektDAO.skrivUtProsjektInfo(prosjektId);
                    break;
                }
                case 17: {
                    System.out.print("Skriv inn prosjektId: ");
                    int prosjektId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Skriv inn ansattId: ");
                    int ansattId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Skriv inn timer: ");
                    int timer = scanner.nextInt();
                    scanner.nextLine();
                    prosjektDeltagelseDAO.leggTilTimerForAnsatt(prosjektId, ansattId, timer);
                    break;
                }
                case 18: {
                    System.out.print("Skriv inn ansattid: ");
                    int ansattId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Skriv inn prosjektid: ");
                    int prosjektId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Skriv inn rolle: ");
                    String rolle = scanner.nextLine();
                    prosjektDeltagelseDAO.registrerProsjektDeltagelse(prosjektId, ansattId, rolle);

                    break;
                }
                case 0: {
                    System.out.println("Avslutter...");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Ugyldig valg, prøv igjen.");
                    break;
                }
            }
        }
    }
}
