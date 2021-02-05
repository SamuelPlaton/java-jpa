package domain.banque;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BANQUE")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "banque")
    private Set<Client> clients;

    public Banque(String nom) {
        this.nom = nom;
    }
}
