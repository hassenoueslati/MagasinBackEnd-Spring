package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Produit;

public interface ProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	void deleteProduit(Long idProduit);

	Produit updateProduit(Produit p);

	Produit retrieveProduit(Long idProduit);
	
	void assignFournisseurToProduit(Long fournisseurId, Long produitId);
	
	List<Produit> retrieveProduitsParPrixdesc();
	
	List<Produit> retrieveProduitsParPrixAsc();
	

}
