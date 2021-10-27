package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Transporteur;
import tn.esprit.spring.repository.TransporteurRepository;

public class TransporteurServiceImp implements TransporteurService {

	@Autowired
	TransporteurRepository transporteurRepository ;
	
	@Override
	public List<Transporteur> retrieveAllTransporteur() {
		return (List<Transporteur>)transporteurRepository.findAll();

	}

	@Override
	public Transporteur addTransporteur(Transporteur r) {
		return transporteurRepository.save(r);

	}

	@Override
	public void deleteTransporteur(Long idTransporteur) {
	    transporteurRepository.deleteById(idTransporteur);		

	}

	@Override
	public Transporteur updateTransporteur(Transporteur r) {
		return transporteurRepository.save(r);

	}

	@Override
	public Transporteur retrieveTransporteur(Long idTransporteur) {
		return transporteurRepository.findById(idTransporteur).get();

	}

}
