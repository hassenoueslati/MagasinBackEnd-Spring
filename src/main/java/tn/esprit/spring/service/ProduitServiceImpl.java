package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.ProduitRepository;

@Slf4j
@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository ;
	@Override
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) produitRepository.findAll() ;
	}

	@Override
	public Produit addProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Long idProduit) {
		produitRepository.deleteById(idProduit);
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long idProduit) {
		return produitRepository.findById(idProduit).get();
	}

}
