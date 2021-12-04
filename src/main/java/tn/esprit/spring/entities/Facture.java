package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Facture")
public class Facture implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture;
	private Float montantRemise;
	private Float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailFacture> detailFacture;
	@JsonIgnore
    @ManyToOne
    User user;
	@OneToOne(mappedBy="Facture")
	private Command Command;

    
}
