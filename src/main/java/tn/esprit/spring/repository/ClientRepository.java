package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Profession;
import tn.esprit.spring.entities.CategorieClient;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	@Modifying
    @Query("update Client c set c.nom = :nom , c.prenom = :prenom , c.dateNaissance = :dateN ,"
            + " c.email = :email , c.CategorieClient = :CategorieClient , c.Profession = :Profession where c.idClient = :id")
    int updateClient(@Param("nom")String nom, @Param("prenom")String prenom, @Param("dateN") Date dateN,
                         @Param("email")String email,@Param("CategorieClient") CategorieClient categorieClient,
                         @Param("Profession") Profession Profession,
                         @Param("idClient")Long idClient);

    //JPQL//
    @Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN :D1 AND :D2 ")
    List<Client> JPQL(@Param("D1") Date D1 , @Param("D2") Date D2 );

    //SQL//
    @Query(value = "SELECT * FROM client c WHERE c.date_naissance BETWEEN :D1 AND :D2 " ,
            nativeQuery = true)
    List<Client> SQL(@Param("D1") Date D1 , @Param("D2") Date D2);
}
