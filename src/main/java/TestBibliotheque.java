import domain.Client;
import domain.Emprunt;
import domain.Livre;

import javax.persistence.*;
import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {
        // Create our entities managers
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-b3-g1");
        EntityManager em = emf.createEntityManager();
        // Create transaction
        em.getTransaction().begin();

        // Retrieve a Emprunt and his Client and Livres[]
        Emprunt emprunt = em.find(Emprunt.class, 1);
        System.out.println(emprunt.toStringComplete());

        // Retrieve an Client and his Emprunts[]
        Client client = em.find(Client.class, 1);
        System.out.println(client);
        
        // Commit
        em.getTransaction().commit();

        // Close our entities managers
        em.close();
        emf.close();
    }
}
