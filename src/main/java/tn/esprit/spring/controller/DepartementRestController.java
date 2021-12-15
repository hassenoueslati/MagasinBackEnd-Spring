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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.service.DepartementServiceImpl;

@RestController

@Api(tags = "Departement management")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/departement")
public class DepartementRestController {

	@Autowired  
	DepartementServiceImpl DepartementServImp;
	@ApiOperation(value = "afficher tous les departements")
	@GetMapping("retrieve-all-departements")
	@ResponseBody
	public List<Departement> getAllDepartementts(){
		return this.DepartementServImp.retrieveAllDepartements();
	}
	@ApiOperation(value = "afficher departement par id")
	@GetMapping("/retrieve-departement/{idDepartement}")  
	@ResponseBody
	private Optional<Departement> getDepartement(@PathVariable("idDepartement") Long idDepartement)   
	{  
		return Optional.ofNullable(this.DepartementServImp.retrieveDepartement(idDepartement)); 
	}
	@ApiOperation(value = "suuprimer departement")
	@DeleteMapping("/remove-departement/{idDepartement}")  
	@ResponseBody
	private void deleteDepartement(@PathVariable("idDepartement") Long idDepartement)   
	{  
		this.DepartementServImp.deleteDepartement(idDepartement);
	}
	@ApiOperation(value = "update departement")
	@PutMapping("/modify-departement")
	@ResponseBody
	public Departement modifyDepartement(@RequestBody Departement c) {
		return this.DepartementServImp.updateDepartement(c);
	}
	@ApiOperation(value = "ajouter departement")
	@PostMapping("/add-departement")
	@ResponseBody
	public Departement addDepartement(@RequestBody Departement c) {
		return this.DepartementServImp.addDepartement(c);
	}

}
