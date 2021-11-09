package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.service.ReclamationServiceImp;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
	@Autowired
	ReclamationServiceImp reclamationService ;
	
	// http://localhost:8089/SpringMVC/reclamation/retrieve-all-Reclamations
	@GetMapping("/retrieve-all-Reclamations")
	@ResponseBody
	public List<Reclamation> getAllReclamation(){
		List<Reclamation> listReclamations = reclamationService.retrieveAllReclamations();
		return listReclamations;
	}
	
	// http://localhost:8089/SpringMVC/reclamation/retrieve-reclamation/8
	@GetMapping("/retrieve-reclamation/{reclamation-id}")
	@ResponseBody
	public Reclamation retrieveClient(@PathVariable("reclamation-id") Long idReclamation) {
	return reclamationService.retrieveReclamation(idReclamation);
	}
	
	// http://localhost:8089/SpringMVC/reclamation/add-reclamation
	@PostMapping("/add-reclamation")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation r)
	{
		Reclamation reclamation = reclamationService.addReclamation(r);
	return reclamation;
	}
	
	// http://localhost:8089/SpringMVC/reclamation/remove-reclamation/{reclamation-id}
	@DeleteMapping("/remove-reclamation/{reclamation-id}")
	@ResponseBody
	public void removeReclamation(@PathVariable("reclamation-id") Long idReclamation) {
		reclamationService.deleteReclamation(idReclamation);
	}

	// http://localhost:8089/SpringMVC/reclamation/modify-reclamation
	@PutMapping("/modify-reclamation")
	@ResponseBody
	public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {
	return reclamationService.updateReclamation(reclamation);
	}
}
