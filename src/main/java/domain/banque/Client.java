package domain.banque;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "NOM", nullable = false)
    private String nom;
    @Column(name = "PRENOM", nullable = false)
    private String prenom;
    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn( name="ID_BANQUE" )
    private Banque banque;
    @ManyToMany
    @JoinTable(name = "CLI_COMPTE",
            joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"))
    private Set<Compte> comptes;

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque, Set<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
        this.comptes = comptes;
    }

    public Client() {
    }
}
