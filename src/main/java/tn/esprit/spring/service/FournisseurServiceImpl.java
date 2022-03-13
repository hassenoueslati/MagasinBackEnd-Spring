package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.FournisseurRepository;
@Service
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepository;


	
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		return (List<Fournisseur>) fournisseurRepository.findAll();	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		return fournisseurRepository.save(f);
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);	
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long idFournisseur) {
		return fournisseurRepository.findById(idFournisseur).get();
	}

	@Override
	public List<Produit> getProduitByFounisseur(long idFounisseur){
			return fournisseurRepository.getProduitByFournisseur(idFounisseur);
	}
	
}
