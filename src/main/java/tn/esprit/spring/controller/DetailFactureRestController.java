package tn.esprit.spring.controller;

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

import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.service.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Detailfacture")
public class DetailFactureRestController {
	@Autowired
	DetailFactureService DetailFactureService;
	// http://localhost:8081/SpringMVC/Detailfacture/retrieve-all-Detailfactures
		@GetMapping("/retrieve-all-Detailfactures")
		@ResponseBody
		public List<DetailFacture> getDetailFactures() {
		List<DetailFacture> list = DetailFactureService.retrieveAllDetailFacture();
		return list;

	}
		// http://localhost:8081/SpringMVC/DetailFacture/addDetailFacture
		 @PostMapping("/addDetailFacture")
		 @ResponseBody
		 public DetailFacture addDetailFacture(@RequestBody DetailFacture f) {
			 DetailFacture DetailFacture = DetailFactureService.addDetailFacture(f);
		 return DetailFacture;
	}
		 
			// http://localhost:8081/SpringMVC/DetailFacture/remove-DetailFacture/1
		 @DeleteMapping("/remove-DetailFacture/{id}")
		 @ResponseBody
		 public void deleteDetailFacture(@PathVariable("id") Long id) {
			 DetailFactureService.deleteDetailFacture(id);
		 }
		 
		// http://localhost:8081/SpringMVC/DetailFacture/modify-DetailFacture
				 @PutMapping("/modify-DetailFacture")
				 @ResponseBody
				 public DetailFacture updateDetailFacture(@RequestBody DetailFacture DetailFacture) {
				 return DetailFactureService.updateDetailFacture(DetailFacture);
				  }	
}
