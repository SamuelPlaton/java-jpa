package domain.books;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITRE", nullable = false)
    private String titre;
    @Column(name = "AUTEUR", nullable = false)
    private String auteur;
    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"))
    private Set<Emprunt> emprunts;

    public Livre() { }

    public Livre(String titre, String auteur, Set<Emprunt> emprunts) {
        this.titre = titre;
        this.auteur = auteur;
        this.emprunts = emprunts;
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }

    public String toStringComplete() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", emprunts='" + emprunts + '\'' +
                '}';
    }
}
