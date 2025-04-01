import DAO.AnsattDAO;
import DAO.AvdelingDAO;
import Entity.Ansatt;
import Entity.Avdeling;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        //Lage en meny senere

        AnsattDAO  ansattDAO = new AnsattDAO();
        AvdelingDAO avdelingDAO = new AvdelingDAO();

        Avdeling a1 = avdelingDAO.finnAvdelingMedId(1);
        a1.skrivUtMedAnsatte();





//        ansattDAO.oppdaterAnsattStilling(7,"underingeniør");      Funker
//        Ansatt a3  = ansattDAO.finnAnsattMedBrukernavn("pao");
//        System.out.println(a3);

//        ansattDAO.leggTilAnsatt("pao","per","arne olav", LocalDate.now(),"overingeniør",105000);  Funker
//        Ansatt a3  = ansattDAO.finnAnsattMedBrukernavn("pao");
//        System.out.println(a3);

//        Ansatt a1   = ansattDAO.finnAnsattMedId(1);               Funker

//        Ansatt a2 = ansattDAO.finnAnsattMedBrukernavn("edam");    Funker
//        ansattDAO.hentAlleAnsatte();  Funker




    }
}
