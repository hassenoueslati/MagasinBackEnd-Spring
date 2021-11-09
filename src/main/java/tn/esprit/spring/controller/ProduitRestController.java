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

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.service.ProduitServiceImpl;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	ProduitServiceImpl produitService ;
	
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> listProduits = produitService.retrieveAllProduits();
		return listProduits ;
	}
	
	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("produit-id") Long idProduit) {
	return produitService.retrieveProduit(idProduit);
	}
	
	// http://localhost:8089/SpringMVC/produit/add-produit
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p)
	{
		Produit produit = produitService.addProduit(p);
	return produit;
	}
	
	// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long idProduit) {
		produitService.deleteProduit(idProduit);
	}
	
	// http://localhost:8089/SpringMVC/produit/modify-produit
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit produit) {
	return produitService.updateProduit(produit);
	}
	
	
	
}
