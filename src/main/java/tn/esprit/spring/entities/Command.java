package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Command")
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCommand")
    private Long idCommand;
    @Temporal(TemporalType.DATE)
    private Date dateCommand;
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    private String AdresseLivraison;
    private float FraisLivraison;
    @OneToOne
    private Facture Facture;
    
}
