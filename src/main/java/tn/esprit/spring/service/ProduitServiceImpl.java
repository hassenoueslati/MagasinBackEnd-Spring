package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;

@Slf4j
@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository ;
	@Autowired
	FournisseurRepository fournisseurRepository ;
	@Autowired
	RayonRepository rayonRepository ;
	@Autowired
	DetailFactureRepository detailFactureRepository ;
	
	
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
	
	@Transactional
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Produit produit=produitRepository.findById(produitId).orElse(null);
        Fournisseur fournisseur=fournisseurRepository.findById(fournisseurId).orElse(null);
        produit.getFournisseur().add(fournisseur);
    }
	
	@Override
	public List<Produit> retrieveProduitsParPrixdesc(){
		return (List<Produit>) produitRepository.getProduitsParPrixDesc();
	}
	
	@Override
	public List<Produit> retrieveProduitsParPrixAsc(){
		return (List<Produit>) produitRepository.getProduitsParPrixAsc();
	}
	
}
