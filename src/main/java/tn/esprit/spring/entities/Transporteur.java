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

@Entity
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

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getOrigine() {
			return origine;
		}

		public void setOrigine(String origine) {
			this.origine = origine;
		}

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		public Integer getQuantiteMax() {
			return quantiteMax;
		}

		public void setQuantiteMax(Integer quantiteMax) {
			this.quantiteMax = quantiteMax;
		}

		public Set<Produit> getProduits() {
			return produits;
		}

		public void setProduits(Set<Produit> produits) {
			this.produits = produits;
		}

		public Transporteur(String nom, String prenom, String age, String origine, String matricule,
				Integer quantiteMax, Set<Produit> produits) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.origine = origine;
			this.matricule = matricule;
			this.quantiteMax = quantiteMax;
			this.produits = produits;
		}

		public Transporteur() {
			super();
		}
		

}