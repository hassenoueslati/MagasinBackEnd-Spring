package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
@Table( name = "Transporteur")
public class Transporteur implements Serializable {
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idTransporteur")
		private Long idTransporteur;
		private String nom;
		private String prenom;
		private String age;
		private String origine;
		private String matricule;
		private  Integer  quantiteMax;
       @JsonIgnore
	   @OneToMany(cascade = CascadeType.ALL, mappedBy="transporteur")
	   private Set<Command> command;
		@ManyToMany(mappedBy="Transporteur", cascade = CascadeType.ALL)
		private Set<Produit> produits;

		
}