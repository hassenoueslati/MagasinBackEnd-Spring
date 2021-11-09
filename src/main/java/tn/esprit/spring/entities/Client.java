package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Data
@Table( name = "Client")
public class Client implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idClient")
private Long idClient; // Clé primaire
private String nom;
private String prenom;
private String email;
private String password;
@Temporal(TemporalType.DATE)
private Date dateNaissance;
@Enumerated(EnumType.STRING)
private Profession profession;
@Enumerated(EnumType.STRING)
public CategorieClient categorieClient;
@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
private Set<Facture> facture;
@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
private Set<Reclamation> reclamation;
public Client(String nom, String prenom,Date dateNaissance, String email, String password,
		CategorieClient categorieClient,Profession profession) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.dateNaissance = dateNaissance;
	this.profession = profession;
	this.categorieClient = categorieClient;
}
public Client() {
	super();
}




}