package tn.esprit.spring.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.service.ReclamationServiceImp;

@RestController
@Api(tags="Reclamation")
@RequestMapping("/reclamation")
@CrossOrigin(origins="*")
public class ReclamationController {
	@Autowired
	ReclamationServiceImp reclamationService ;
	@Autowired
	EmailSenderService emailSenderService ;
	
	// http://localhost:8089/SpringMVC/reclamation/retrieve-all-Reclamations
	@GetMapping("/retrieve-all-Reclamations")
	@ApiOperation("routrouver tous les reclamations")
	@ResponseBody
	public List<Reclamation> getAllReclamation(){
		List<Reclamation> listReclamations = reclamationService.retrieveAllReclamations();
		return listReclamations;
	}
	
	// http://localhost:8089/SpringMVC/reclamation/retrieve-reclamation/8
	@GetMapping("/retrieve-reclamation/{reclamation-id}")
	@ApiOperation("routrouver une reclamation")
	@ResponseBody
	public Reclamation retrieveClient(@PathVariable("reclamation-id") Long idReclamation) {
	return reclamationService.retrieveReclamation(idReclamation);
	}
	
	// http://localhost:8089/SpringMVC/reclamation/add-reclamation
	@PostMapping("/add-reclamation")
	@ApiOperation("ajouter les reclamations")
	public Reclamation addReclamation(@RequestBody Reclamation r) {
		Date date = new Date(System.currentTimeMillis());
		r.setDate(date);
		Reclamation reclamation = reclamationService.addReclamation(r);
		emailSenderService.SendEmail("badisraissi98@gmail.com", "Reclamation", "votre reclamation est bien recu");
	return reclamation;
	}
	
	// http://localhost:8089/SpringMVC/reclamation/remove-reclamation/{reclamation-id}
	@DeleteMapping("/remove-reclamation/{reclamation-id}")
	@ApiOperation("effacer les reclamations")
	@ResponseBody
	public void removeReclamation(@PathVariable("reclamation-id") Long idReclamation) {
		reclamationService.deleteReclamation(idReclamation);
	}

	// http://localhost:8089/SpringMVC/reclamation/modify-reclamation
	@PutMapping("/modify-reclamation")
	@ApiOperation("modifier tous les reclamations")
	@ResponseBody
	public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {
	return reclamationService.updateReclamation(reclamation);
	}
}
