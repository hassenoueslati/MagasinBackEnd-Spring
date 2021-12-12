package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@Table( name = "Stock")

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)

public class Stock implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock;
	private Integer qte;
	private Integer qteMin;
	private String libelleStock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> Produit;
}