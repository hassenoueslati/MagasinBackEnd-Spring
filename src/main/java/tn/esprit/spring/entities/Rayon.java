package tn.esprit.spring.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "Rayon")


public class Rayon  implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon;
	private String code;
	private String libelle;
	private String image;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> Produit;
	@ManyToOne
	Departement departement;




}
