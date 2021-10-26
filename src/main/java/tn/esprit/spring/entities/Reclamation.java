package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Reclamation")

public class Reclamation implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idReclamation")
	private Long idReclamation;
	private String description;
	private Date date;
	 @ManyToOne
	    Client client;
	public Long getIdReclamation() {
		return idReclamation;
	}
	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Reclamation(Long idReclamation, String description, Date date, Client client) {
		super();
		this.idReclamation = idReclamation;
		this.description = description;
		this.date = date;
		this.client = client;
	}
	public Reclamation() {
		super();
	}
	 
}