package domain.banque;

import domain.books.Client;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "OPERATION")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;
    @Column(name = "MONTANT", nullable = false)
    private double montant;
    @Column(name = "MOTIF", nullable = false)
    private String motif;
    @ManyToOne
    @JoinColumn( name="ID_COMPTE" )
    private Compte compte;

    public Operation(LocalDateTime date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    public Operation() {
    }
}
