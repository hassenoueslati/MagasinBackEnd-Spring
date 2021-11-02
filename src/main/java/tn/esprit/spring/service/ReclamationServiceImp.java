package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.repository.StockRepository;
@Slf4j
@Service
public class ReclamationServiceImp implements ReclamationService {

	@Autowired
	ReclamationRepository reclamationRepository ;
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		// TODO Auto-generated method stub
		return (List<Reclamation>)reclamationRepository.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(Long idReclamation) {
		// TODO Auto-generated method stub
		reclamationRepository.deleteById(idReclamation);
	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation retrieveReclamation(Long idReclamation) {
		// TODO Auto-generated method stub
		return reclamationRepository.findById(idReclamation).get();
	}

}
