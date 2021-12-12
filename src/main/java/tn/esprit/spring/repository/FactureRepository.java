package tn.esprit.spring.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {
	
	@Query("Select f from Facture f WHERE f.user.idUser like %?1 ")
	List<Facture> getFacturesByUser(Long idUser);//Long idClient
	
	
	@Query("SELECT f FROM Facture f WHERE f.dateFacture BETWEEN ?1 AND ?2")
	List<Facture> retrieveFacturesByDates(Date date1, Date date2);
	

	
	@Query("SELECT SUM(f.montantFacture) FROM Facture f WHERE f.user.categorieClient = ?1 AND (f.dateFacture BETWEEN ?2 AND ?3)")
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
	
}
