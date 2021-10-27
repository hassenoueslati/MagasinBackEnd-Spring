package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Transporteur;

public interface TransporteurService {
	
	List<Transporteur> retrieveAllTransporteur();

	Transporteur addTransporteur(Transporteur r);

	void deleteTransporteur(Long idTransporteur);

	Transporteur updateTransporteur(Transporteur r);

	Transporteur retrieveTransporteur(Long idTransporteur);

}
