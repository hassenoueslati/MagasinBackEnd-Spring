package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

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
@Entity
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
		public CategorieClient categorieClient;
		@OneToOne(mappedBy="detailProduit")
		private Produit Produit;

		
		public DetailProduit(Long idDetailProduit, Date dateCreation, Date dateDerniereModification,
				CategorieClient categorieClient) {
			super();
			this.idDetailProduit = idDetailProduit;
			this.dateCreation = dateCreation;
			this.dateDerniereModification = dateDerniereModification;
			this.categorieClient = categorieClient;
		}


		public Long getIdDetailProduit() {
			return idDetailProduit;
		}


		public void setIdDetailProduit(Long idDetailProduit) {
			this.idDetailProduit = idDetailProduit;
		}


		public Date getDateCreation() {
			return dateCreation;
		}


		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}


		public Date getDateDerniereModification() {
			return dateDerniereModification;
		}


		public void setDateDerniereModification(Date dateDerniereModification) {
			this.dateDerniereModification = dateDerniereModification;
		}


		public CategorieClient getCategorieClient() {
			return categorieClient;
		}


		public void setCategorieClient(CategorieClient categorieClient) {
			this.categorieClient = categorieClient;
		}


		public DetailProduit() {
			super();
		}
		
		

	}



