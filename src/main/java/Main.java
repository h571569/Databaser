import DAO.AnsattDAO;
import DAO.AvdelingDAO;
import Entity.Ansatt;

public class Main {
    public static void main(String[] args) {


        //Lage en meny senere

        AnsattDAO  ansattDAO = new AnsattDAO();
        AvdelingDAO avdelingDAO = new AvdelingDAO();

        Ansatt a1 = ansattDAO.finnAnsattMedId(1);
        Ansatt a2 = ansattDAO.finnAnsattMedId(2);
        a1.skrivUtMedProsjekter();
        a2.skrivUtMedProsjekter();

        ansattDAO.hentAlleAnsatte();

        ansattDAO.oppdaterAnsattStilling();
        ansattDAO.leggTilAnsatt();




    }
}
