package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.*;
@Slf4j
@Service
public class FactureServiceImpl implements FactureService{
	@Autowired
	ProduitRepository ProduitRepository ;
	@Autowired
	FactureRepository FactureRepository ;
	@Autowired
	private UserService userService;
	@Autowired
	private DetailFactureService detailFactureService;
	@Override
	public List<Facture> retrieveAllFacture() {
		return (List<Facture>) FactureRepository.findAll();
	}

	@Override
	public Facture addFacture(Facture f) {
		return FactureRepository.save(f);
	}

	@Override
	public void deleteFacture(Long id) {
		FactureRepository.deleteById(id);		
	}

	@Override
	public Facture updateFacture(Facture f) {
		return FactureRepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return FactureRepository.findById(id).get();
	}
	@Override
	public List<Facture> getFacturesByUser(Long idUser) {
		return FactureRepository.getFacturesByUser(idUser);
	}
	@Override
	public Facture addFacture(Facture f, Long idUser) {
		User user = userService.retrieveClient(idUser);
		f.setUser(user);
		
		float montantTotalFacture=0f;
		float montantRemiseFacture=0f;
		for (DetailFacture detailFact : f.getDetailFacture()) {
			float montantDetail=0f;
			float montantRemiseDetail=0f;
			
			//montantDetail=detailFact.getProduit().getPrixUnitaire()*detailFact.getQte();
			montantRemiseDetail = montantDetail*detailFact.getPourcentageRemise()/100;
			detailFact.setPrixTotal(montantDetail);
			detailFact.setMontantRemise(montantRemiseDetail);
			detailFactureService.updateDetailFacture(detailFact);
			montantTotalFacture+=montantDetail;
			montantRemiseFacture+=montantRemiseDetail;
		}
		
		f.setMontantFacture(montantRemiseFacture);
		f.setMontantRemise(montantRemiseFacture);
		
		return FactureRepository.save(f);
	}
	@Override
	public List<Facture> retrieveFacturesByDates(Date date1, Date date2) {
		return FactureRepository.retrieveFacturesByDates(date1, date2);
	}
	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		return FactureRepository.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
	}


}
