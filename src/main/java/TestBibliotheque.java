import domain.books.Client;
import domain.books.Emprunt;
import domain.books.Livre;

import javax.persistence.*;

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

        // Retrieve a Client and his Emprunts[]
        Client client = em.find(Client.class, 1);
        System.out.println(client);

        // Retrieve a Livre and his Emprunts[]
        Livre livre = em.find(Livre.class, 1);
        System.out.println(livre.toStringComplete());
        
        // Commit
        em.getTransaction().commit();

        // Close our entities managers
        em.close();
        emf.close();
    }
}
