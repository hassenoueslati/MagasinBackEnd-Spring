package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "Command")
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCommand")
    private Long idCommand;
    @Temporal(TemporalType.DATE)
    private Date dateCommand;
    @ManyToOne
    User user ;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Produit> Produit;
    @ManyToOne
    Transporteur transporteur ;
}
