package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;

public interface FactureService {

	public List<Facture> retrieveAllFacture() ;


	public Facture addFacture(Facture f);
	public void deleteFacture(Long id);
	
	public Facture updateFacture(Facture f);
	public Optional<Facture> findById(Long id) ;
	public Facture retrieveFacture(Long id);
	public List<Facture> getFacturesByUser(Long idUser);
	public Facture addFacture(Facture f, Long idUser) ;
	public List<Facture> retrieveFacturesByDates(Date date1, Date date2);
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
}