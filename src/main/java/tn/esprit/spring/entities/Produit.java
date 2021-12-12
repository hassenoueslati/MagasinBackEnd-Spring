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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Produit implements Serializable {
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idProduit")
		private Long idProduit;
		private String code;
		private String libelle;
		private Float prixUnitaire;
		private String picture ;
		//relation one to one 
		@OneToOne
		private DetailProduit detailProduit;
		@ManyToMany(cascade = CascadeType.ALL)
		private Set<Fournisseur> Fournisseur;
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