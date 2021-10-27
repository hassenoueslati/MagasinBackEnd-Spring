package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Reclamation;

public interface ReclamationService {

	List<Reclamation> retrieveAllReclamations();

	Reclamation addReclamation(Reclamation r);

	void deleteReclamation(Long idReclamation);

	Reclamation updateReclamation(Reclamation r);

	Reclamation retrieveReclamation(Long id);

}
