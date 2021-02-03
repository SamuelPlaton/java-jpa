import domain.Livre;

import javax.persistence.*;
import java.util.List;

public class TestJpa {
    public static void main(String[] args) {
        // Create our entities managers
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-b3-g1");
        EntityManager em = emf.createEntityManager();

        // Find a book
        Livre livre = em.find(Livre.class, 1);
        System.out.println(livre);

        em.getTransaction().begin();
        // Create a book
        Livre livreAjouter = new Livre("Titre 1", "Auteur 1");
        em.persist(livreAjouter);

        // Modify a book
        Livre livreModifier = em.find(Livre.class, 5);
        if(livreModifier != null){
            livreModifier.setTitre("Du plaisir dans la cuisine");
            em.merge(livreModifier);
        }

        // Delete a book
        Livre livreSupprimer = em.find(Livre.class, 4);
        if(livreSupprimer != null){
            em.remove(livreSupprimer);
        }

        // Requests
        // By title
        TypedQuery<Livre> query1 = em.createQuery("select L from Livre L where L.titre = 'Germinal'", Livre.class);
        Livre livreQuery1 = query1.getResultList().get(0);
        System.out.println(livreQuery1);
        // By author
        TypedQuery<Livre> query2 = em.createQuery("select L from Livre L where L.auteur = 'Jean-Pierre Coffe'", Livre.class);
        Livre livreQuery2 = query2.getResultList().get(0);
        System.out.println(livreQuery2);
        // All Books
        TypedQuery<Livre> query3 = em.createQuery("select L from Livre L", Livre.class);
        List<Livre> livreQuery3 = query3.getResultList();
        for(Livre livreDisplay: livreQuery3){
            System.out.println(livreDisplay);
        }

        // Commit
        em.getTransaction().commit();

        // Close our entities managers
        em.close();
        emf.close();
    }
}
