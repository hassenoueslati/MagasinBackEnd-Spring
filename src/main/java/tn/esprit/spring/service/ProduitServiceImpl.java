package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.ProduitRepository;

public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository ;
	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		return (List<Produit>) produitRepository.findAll() ;
	}

	@Override
	public Produit addProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return produitRepository.findById(id).get();
	}

}
