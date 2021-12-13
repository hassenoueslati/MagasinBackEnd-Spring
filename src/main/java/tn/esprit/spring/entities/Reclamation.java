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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="idReclamation")
	private Long idReclamation;
	private String Subject;
	private String description;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
	@JsonIgnore
	 @ManyToOne
	 User user;

	 public Reclamation() {
		 
	 }
	public Reclamation(Long idReclamation, String description, Date date, User user) {
		super();
		this.idReclamation = idReclamation;
		this.description = description;
		this.date = date;
		this.user = user;
	}
	
	 
	 
	 
}