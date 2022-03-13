package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import java.util.Date;
import java.util.List;
import java.util.Map;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repository.FactureRepository;
import  tn.esprit.spring.service.*;


@RestController
@Api(tags = "Facture management")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/facture")

public class FactureRestController {
	@Autowired
	FactureService FactureService;
	@Autowired
	 FactureRepository Facturerep;
	// http://localhost:8081/SpringMVC/facture/retrieve-all-factures
		@GetMapping("/retrieve-all-factures")
		@ResponseBody
		public List<Facture> getFactures() {
		List<Facture> list = FactureService.retrieveAllFacture();
		return list;

	}
		// http://localhost:8081/SpringMVC/facture/retrieve-facture/1
		@GetMapping("/retrieve-facture/{id}")
		@ResponseBody
		public Facture retrieveFacture(@PathVariable("id") Long id) {
		return FactureService.retrieveFacture(id);
		 }

		// http://localhost:8081/SpringMVC/facture/add-facture
		 @PostMapping("/add-facture")
		 @ResponseBody
		 public Facture addFacture(@RequestBody Facture f) {
			 Facture facture = FactureService.addFacture(f);
		 return facture;
	}
		 // ajout facture by user
			@ApiOperation(value = "Ajouter une nouvelle facture")
			@PostMapping("/addfacture/{idUser}")
			@ResponseBody
			public Facture addFactureUser(@RequestBody Facture f, @PathVariable("idUser") Long idUser)
			{		
				return FactureService.addFacture(f, idUser);
			}
			
		 
			// http://localhost:8081/SpringMVC/facture/remove-facture/1
		 @DeleteMapping("/remove-facture/{id}")
		 @ResponseBody
		 public void deleteFacture(@PathVariable("id") Long id) {
			 FactureService.deleteFacture(id);
		 }
		// http://localhost:8081/SpringMVC/facture/modify-facture
		 @PutMapping("/modify-facture")
		
		 public Facture updateDetailFacture(@RequestBody Facture facture) {
		 return FactureService.updateFacture(facture);
		  }	
		 
		 
		
			@GetMapping("/retrieve-all-factures-by-user/{idUser}")
			@ResponseBody
			public List<Facture> getFacturesByUser(@PathVariable("idUser") Long idUser) {
			return FactureService.getFacturesByUser(idUser);
			}
			
			
			@ApiOperation(value = "Récupérer la liste des factures par dates")
			@GetMapping("/retrieve-factures-by-dates")
			@ResponseBody
			public List<Facture> retrieveFacturesByDates(@RequestParam Map<String, Date> dates) {

			return FactureService.retrieveFacturesByDates(dates.get("dateDeb"), dates.get("dateFin"));
			}

		@ApiOperation(value = "Récupérer la liste des factures par dates pour une catégorie client par dates")
			@GetMapping("/retrieve-factures-by-dates-categ-client/{categ}")
			@ResponseBody
			public float getChiffreAffaireParCategorieClient(@PathVariable("categ") CategorieClient categClt, @RequestParam Map<String, Date> dates) {
			return FactureService.getChiffreAffaireParCategorieClient(categClt, dates.get("dateDeb"), dates.get("dateFin"));
			}
		@PutMapping("updateFac/{idFacture}")
		public ResponseEntity<?> updateFac(@PathVariable Long idFacture, @RequestBody Facture fac ){
			
			if(this. FactureService.findById(idFacture).isPresent()) {
				
				fac.setIdFacture(idFacture);
				return new ResponseEntity<>(FactureService.addFacture(fac),HttpStatus.OK);
			}
			else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		

		
		
			

}
