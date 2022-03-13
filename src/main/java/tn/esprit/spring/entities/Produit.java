package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
		private String picture ;
		@Temporal(TemporalType.DATE)
		private Date dateCreation;
		@Temporal(TemporalType.DATE)
		private Date dateDerniereModification;
		@Enumerated(EnumType.STRING)
		public CategorieProduit categorieProduit;
		private Long nbLike ;

		@JsonIgnore
		@ManyToMany(cascade = CascadeType.ALL)
		private Set<Fournisseur> Fournisseur;
		@JsonIgnore
		@ManyToOne
		Rayon rayon;
		@JsonIgnore
		@ManyToOne
		Stock stock;
		 @JsonIgnore
		@OneToMany(mappedBy="produit")
		private Set<DetailFacture> detailFacture;
		public Produit(String code, String libelle, Float prixUnitaire) {
			super();
			this.code = code;
			this.libelle = libelle;
			this.prixUnitaire = prixUnitaire;
		}
		

}