import domain.banque.Adresse;
import domain.banque.Banque;
import domain.banque.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class TestBanque {
    public static void main(String[] args) {
        // Create our entities managers
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-b3-g2");
        EntityManager em = emf.createEntityManager();
        // Create transaction
        em.getTransaction().begin();

        // Create banque
        Banque banque = new Banque("Banque 1");
        em.persist(banque);
        // Create Client affiliated to banque
        /*Adresse adresse = new Adresse(15, "Rue", 44000, "Nantes");
        LocalDate date = LocalDate.of(2000, 1, 7);
        em.persist(new Client("Samuel", "Platon", date, adresse, banque, null));*/

        // Commit
        em.getTransaction().commit();

        // Close our entities managers
        em.close();
        emf.close();
    }
}
