import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class main {

    private static EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("personPCU");
    }

    /* ------------------------------------------------------------------- */

    public static void main(String[] args) {

        Ansatt p = finnPersonMedId(1);
        System.out.println(p);
    }

    private static Ansatt finnPersonMedId(int id) {

        System.out.println("Kobler til database...");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }
}
