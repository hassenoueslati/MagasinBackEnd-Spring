package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Produit;

import java.util.List;

public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {

    @Query("SELECT p from Produit p WHERE p.Fournisseur.size like ?1")
    List<Produit> getProduitByFournisseur(long idFournisseur);
}
