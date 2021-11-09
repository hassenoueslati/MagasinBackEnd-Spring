package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
		
		@ManyToMany(mappedBy="ProduitT", cascade = CascadeType.ALL)
		private Set<Produit> produits;

		
}