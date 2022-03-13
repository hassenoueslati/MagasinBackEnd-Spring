package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.service.DepartementServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/departement")
public class DepartementRestController {

	@Autowired  
	DepartementServiceImpl DepartementServImp;
	
	@GetMapping("retrieve-all-departements")
	@ResponseBody
	public List<Departement> getAllDepartementts(){
		return this.DepartementServImp.retrieveAllDepartements();
	}
	
	@GetMapping("/retrieve-departement/{idDepartement}")  
	@ResponseBody
	private Optional<Departement> getDepartement(@PathVariable("idDepartement") Long idDepartement)   
	{  
		return Optional.ofNullable(this.DepartementServImp.retrieveDepartement(idDepartement)); 
	}
	
	@DeleteMapping("/remove-departement/{idDepartement}")  
	@ResponseBody
	private void deleteDepartement(@PathVariable("idDepartement") Long idDepartement)   
	{  
		this.DepartementServImp.deleteDepartement(idDepartement);
	}
	
	@PutMapping("/modify-departement")
	@ResponseBody
	public Departement modifyDepartement(@RequestBody Departement c) {
		return this.DepartementServImp.updateDepartement(c);
	}
	
	@PostMapping("/add-departement")
	@ResponseBody
	public Departement addDepartement(@RequestBody Departement c) {
		return this.DepartementServImp.addDepartement(c);
	}

}
