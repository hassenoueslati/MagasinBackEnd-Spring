package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Profession;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	 @Modifying
	    @Query("update Client c set c.nom = :nom , c.prenom = :prenom , c.dateNaissance = :dateN ,"
	            + " c.email = :email , c.CategorieClient = :CategorieClient , c.Profession = :Profession where c.idClient = :id")
	    int updateClientById(@Param("nom")String nom, @Param("prenom")String prenom, @Param("dateNaissance") Date dateNaissance,
	                         @Param("email")String email, @Param("categorieClient") CategorieClient categorieClient, @Param("profession") Profession Profession,
	                         @Param("id")Long id);

	    //JPQL
	    @Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN :D1 AND :D2 ")
	    List<Client> JPQLretrieveClientsByBirthDate(@Param("D1") Date D1 , @Param("D2") Date D2 );

	    //SQL
	    @Query(value = "SELECT * FROM client c WHERE c.date_naissance BETWEEN :D1 AND :D2 " ,
	            nativeQuery = true)
	    List<Client> SQLretrieveClientsByBirthDate(@Param("D1") Date D1 , @Param("D2") Date D2);
}
