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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
		private Set<Fournisseur> Fournisseur;
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
		public Produit(String code, String libelle, Float prixUnitaire) {
			super();
			this.code = code;
			this.libelle = libelle;
			this.prixUnitaire = prixUnitaire;
		}
		

}