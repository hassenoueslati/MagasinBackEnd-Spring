package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idFacture")
@Table( name = "Facture")
public class Facture implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture;
	private Float montantRemise;
	private Float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
    private Boolean active;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
   private Set<DetailFacture> detailFacture;
    @ManyToOne
    User user;
	@Override
	public int hashCode() {
		return Objects.hash(active, dateFacture, detailFacture, idFacture, montantFacture, montantRemise, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		return Objects.equals(active, other.active) && Objects.equals(dateFacture, other.dateFacture)
				&& Objects.equals(detailFacture, other.detailFacture) && Objects.equals(idFacture, other.idFacture)
				&& Objects.equals(montantFacture, other.montantFacture)
				&& Objects.equals(montantRemise, other.montantRemise) && Objects.equals(user, other.user);
	}
	
    
}
