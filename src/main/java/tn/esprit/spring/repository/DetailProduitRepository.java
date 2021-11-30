package tn.esprit.spring.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.DetailProduit;

@Repository
public interface DetailProduitRepository extends CrudRepository<DetailProduit, Long> {
	@Modifying
    @Query(value = "INSERT INTO DetailProduit (dateCreation,dateDerniereModification,categorieProduit) VALUES (:dateCreation, :dateDerniereModification, :categorieProduit)",nativeQuery = true)
	void insertDetailProduit(@Param("dateCreation") Date dateCreation, @Param ("dateDerniereModification") Date dateDerniereModification ,@Param ("categorieProduit") CategorieProduit categorieProduit);
	
}
