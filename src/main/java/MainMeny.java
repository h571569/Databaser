import DAO.AnsattDAO;
import DAO.AvdelingDAO;
import DAO.ProsjektDAO;
import DAO.ProsjektDeltagelseDAO;
import Entity.Avdeling;
import Entity.Prosjekt;
import Entity.ProsjektDeltagelse;

public class MainMeny {
    public static void main(String[] args) {


        //Lage en meny senere

        AnsattDAO ansattDAO = new AnsattDAO();
        AvdelingDAO avdelingDAO = new AvdelingDAO();
        ProsjektDAO prosjektDAO = new ProsjektDAO();
        ProsjektDeltagelseDAO prosjektDeltagelseDAO = new ProsjektDeltagelseDAO();

        Prosjekt p1 = prosjektDAO.finnProsjektMedId(1);
        p1.skrivUtMedAnsatte();

//        Avdeling avdeling = avdelingDAO.finnAvdelingMedId(6);
//        avdelingDAO.slettAvdelingMedId(6);


//        ansattDAO.slettAnsattMedId(2);
//        Avdeling av1 = avdelingDAO.finnAvdelingMedId(2);
//        av1.skrivUtMedAnsatte();


//        Ansatt a1 = ansattDAO.finnAnsattMedId(1);
//        Avdeling av1 = a1.getAvdeling();
//        System.out.println(av1.getSjef());

//       ansattDAO.oppdaterAvdelingForAnsatt(2, 2);
//       Ansatt a1 = ansattDAO.finnAnsattMedId(1);
//       System.out.println(a1);
//
//       ansattDAO.oppdaterAvdelingForAnsatt(3, 1);
//       Ansatt a2 = ansattDAO.finnAnsattMedId(3);
//       System.out.println(a2);


//        ansattDAO.leggTilAnsatt("pao","per","arne olav", LocalDate.now(),"overingeniør",105000,1);
//        Avdeling a1 = avdelingDAO.finnAvdelingMedId(1);
//        a1.skrivUtMedAnsatte();





//        ansattDAO.oppdaterAnsattStilling(7,"underingeniør");      Funker
//        Ansatt a3  = ansattDAO.finnAnsattMedBrukernavn("pao");
//        System.out.println(a3);


//        Ansatt a1   = ansattDAO.finnAnsattMedId(1);               Funker

//        Ansatt a2 = ansattDAO.finnAnsattMedBrukernavn("edam");    Funker
//        ansattDAO.hentAlleAnsatte();  Funker




    }
}
