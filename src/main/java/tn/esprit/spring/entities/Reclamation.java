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

import lombok.Data;

@Entity
@Data
@Table( name = "Reclamation")

public class Reclamation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idReclamation")
	private Long idReclamation;
	private String description;
	private Date date;
	
	 @ManyToOne
	    Client client;

	 public Reclamation() {
		 
	 }
	public Reclamation(Long idReclamation, String description, Date date, Client client) {
		super();
		this.idReclamation = idReclamation;
		this.description = description;
		this.date = date;
		this.client = client;
	}
	
	 
	 
	 
}