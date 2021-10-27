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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table( name = "Produit")
public class Produit implements Serializable {
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idProduit")
		private Long idProduit;
		private String code;
		private String libelle;
		private Float prixUnitaire;
		//relation one to one 
		@OneToOne
		private DetailProduit detailProduit;
		@ManyToMany(cascade = CascadeType.ALL)
		private Set<Fournisseur> Produit;
		@ManyToMany(cascade = CascadeType.ALL)
		private Set<Transporteur> ProduitT;
		@ManyToOne
		Rayon rayon;
		@ManyToOne
		Stock stock;
		@ManyToOne
		DetailFacture detailFacture;
		
		
		public Long getIdProduit() {
			return idProduit;
		}
		public void setIdProduit(Long idProduit) {
			this.idProduit = idProduit;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public Float getPrixUnitaire() {
			return prixUnitaire;
		}
		public void setPrixUnitaire(Float prixUnitaire) {
			this.prixUnitaire = prixUnitaire;
		}
		public Produit(Long idProduit, String code, String libelle, Float prixUnitaire) {
			super();
			this.idProduit = idProduit;
			this.code = code;
			this.libelle = libelle;
			this.prixUnitaire = prixUnitaire;
		}
		public Produit() {
			super();
		}

}