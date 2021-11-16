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
		public DetailProduit getDetailProduit() {
			return detailProduit;
		}
		public void setDetailProduit(DetailProduit detailProduit) {
			this.detailProduit = detailProduit;
		}
		public Set<Fournisseur> getProduit() {
			return Produit;
		}
		public void setProduit(Set<Fournisseur> produit) {
			Produit = produit;
		}
		public Set<Transporteur> getProduitT() {
			return ProduitT;
		}
		public void setProduitT(Set<Transporteur> produitT) {
			ProduitT = produitT;
		}
		public Rayon getRayon() {
			return rayon;
		}
		public void setRayon(Rayon rayon) {
			this.rayon = rayon;
		}
		public Stock getStock() {
			return stock;
		}
		public void setStock(Stock stock) {
			this.stock = stock;
		}
		public DetailFacture getDetailFacture() {
			return detailFacture;
		}
		public void setDetailFacture(DetailFacture detailFacture) {
			this.detailFacture = detailFacture;
		}
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