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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
@Table( name = "User")
public class User implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idUser")
private Long idUser; // Clé primaire
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
@Enumerated(EnumType.STRING)
public Role role;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<Command> command;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy= "user")
private Set<Facture> facture;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy= "user")
private Set<Reclamation> reclamation;
public User(String nom, String prenom, Date dateNaissance, String email, String password,
			CategorieClient categorieClient, Profession profession , Role role) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.dateNaissance = dateNaissance;
	this.profession = profession;
	this.categorieClient = categorieClient;
	this.role=role;
}
public User() {
	super();
}




}