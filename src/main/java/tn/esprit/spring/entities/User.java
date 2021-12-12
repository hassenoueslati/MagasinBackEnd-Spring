package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
private String image;
private String email;
private String password;
private Boolean enabled;
@Temporal(value = TemporalType.DATE)
private Date dateNaissance;
@Enumerated(EnumType.STRING)
private Profession profession;
@Enumerated(EnumType.STRING)
public CategorieClient categorieClient;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy= "user")
private Set<Facture> facture;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy= "user")
private Set<Reclamation> reclamation;
@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
@JoinTable(name= "user_role",joinColumns = @JoinColumn(name= "idUser") , inverseJoinColumns =
@JoinColumn(name= "role_id"))
private List<Role> roles;
public User(String nom, String prenom, Date dateNaissance, String email, String password,
			CategorieClient categorieClient, Profession profession) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.dateNaissance = dateNaissance;
	this.profession = profession;
	this.categorieClient = categorieClient;
}
public User() {
	super();
}




}