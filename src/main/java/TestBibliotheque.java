import domain.Livre;

import javax.persistence.*;
import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {
        // Create our entities managers
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-b3-g1");
        EntityManager em = emf.createEntityManager();

        // todo: finish tp3

        // Commit
        em.getTransaction().commit();

        // Close our entities managers
        em.close();
        emf.close();
    }
}
