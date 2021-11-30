package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table( name = "DetailProduit")
public class DetailProduit implements Serializable  {
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idDetailProduit")
		private Long idDetailProduit;
		@Temporal(TemporalType.DATE)
		private Date dateCreation;
		@Temporal(TemporalType.DATE)
		private Date dateDerniereModification;
		@Enumerated(EnumType.STRING)
		public CategorieProduit categorieProduit;
		@OneToOne(mappedBy="detailProduit")
		private Produit Produit;
		public DetailProduit(Date dateCreation, Date dateDerniereModification, CategorieProduit categorieProduit) {
			super();
			this.dateCreation = dateCreation;
			this.dateDerniereModification = dateDerniereModification;
			this.categorieProduit = categorieProduit;
		}
		
	}



