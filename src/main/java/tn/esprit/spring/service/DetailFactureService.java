package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;

public interface DetailFactureService {


	public List<DetailFacture> retrieveAllDetailFacture();
	public DetailFacture addDetailFacture(DetailFacture d) ;
	public void deleteDetailFacture(Long id);
	public DetailFacture updateDetailFacture(DetailFacture d);
	public DetailFacture retrieveDetailFacture(Long id) ;


}
