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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.service.FournisseurService;

@RestController
@Api(tags = "Fournissseur management")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fournisseur")
public class FournissseurRestController {

	@Autowired
	FournisseurService fournisseurService;
	
	@ApiOperation(value = "Récupérer la liste des fournisseurs")
	@GetMapping("/retrieve-all-fournisseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
	List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
	return listFournisseurs;
	}
	
	@ApiOperation(value = "Récupérer un fournisseur par Id")
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	@ResponseBody
	public Fournisseur retrieveFournissseur(@PathVariable("fournisseur-id") Long fournissseurId) {
	return fournisseurService.retrieveFournisseur(fournissseurId);
	}
	
	@ApiOperation(value = "Ajouter un nouveau fournisseur")
	@PostMapping("/add-fournisseur")
	@ResponseBody
	public Fournisseur addFournisseur(@RequestBody Fournisseur f)
	{
		Fournisseur fournissseur = fournisseurService.addFournisseur(f);
		return fournissseur;
	}
	
	@ApiOperation(value = "Supprimer un fournisseur par Id")
	@DeleteMapping("/remove-fournissseur/{fournisseur-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournissseurId) {
	fournisseurService.deleteFournisseur(fournissseurId);
	}

	@ApiOperation(value = "Mettre a jour un fournisseur")
	@PutMapping("/modify-fournisseur")
	@ResponseBody
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur f) {
	return fournisseurService.updateFournisseur(f);
	}


	@ApiOperation(value = "Récupérer list produit par fournisseur")
	@GetMapping("/retrieveProduitByfournisseur/{fournisseur-id}")
	@ResponseBody
	public List<Produit> getProduitByFournisseur(@PathVariable("fournisseur-id") long idFournisseur ){
		return fournisseurService.getProduitByFounisseur(idFournisseur);
	}
}
