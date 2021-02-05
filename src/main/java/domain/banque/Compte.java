package domain.banque;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COMPTE")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NUMERO", nullable = false)
    private String numero;
    @Column(name = "SOLDE", nullable = false)
    private double solde;
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;
    @ManyToMany
    @JoinTable(name = "CLI_COMPTE",
            joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
    private Set<Client> clients;

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Compte(String numero, double solde, Set<Operation> operations, Set<Client> clients) {
        this.numero = numero;
        this.solde = solde;
        this.operations = operations;
        this.clients = clients;
    }

    public Compte() {
    }
}
