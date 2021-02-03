package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DATE_DEBUT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "DATE_FIN", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "DELAI", nullable = true)
    private int delai;
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name="ID_CLIENT" )
    private Client client;


    public Emprunt() { }

    public Emprunt(Date dateDebut, Date dateFin, int delai, Client client) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
    }

    public Emprunt(Date dateDebut, Date dateFin, Client client) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
    }

    public Emprunt(Date dateDebut, int delai, Client client) {
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                ", idClient=" + client +
                '}';
    }
}
