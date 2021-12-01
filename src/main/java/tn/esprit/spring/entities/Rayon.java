package tn.esprit.spring.entities;

import lombok.Getter;
import lombok.Setter;

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

@Entity
@Getter
@Setter
@Table( name = "Rayon")


public class Rayon  implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon;
	private String code;
	private String libelle;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> Produit;
	public Long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
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
	public Rayon(Long idRayon, String code, String libelle) {
		super();
		this.idRayon = idRayon;
		this.code = code;
		this.libelle = libelle;
	}
	public Rayon() {
		super();
	}


}
