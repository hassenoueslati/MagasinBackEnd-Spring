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
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.service.ProduitServiceImpl;

@RestController
@Api(tags = "Produit management")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	ProduitServiceImpl produitService ;
	
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ApiOperation(value = "Récupérer la liste des Produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> listProduits = produitService.retrieveAllProduits();
		return listProduits ;
	}
	
	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	@ApiOperation(value = "Récupérer un produit")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("produit-id") Long idProduit) {
	return produitService.retrieveProduit(idProduit);
	}
	
	// http://localhost:8089/SpringMVC/produit/add-produit
	@PostMapping("/add-produit")
	@ApiOperation(value = "Ajouter un nouveau produit")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p)
	{
		Produit produit = produitService.addProduit(p);
	return produit;
	}
	
	// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{idproduit}")
	@ApiOperation(value = "Supprimer un produit")
	@ResponseBody
	public void removeProduit(@PathVariable("idproduit") Long idProduit) {
		produitService.deleteProduit(idProduit);
	}
	
	// http://localhost:8089/SpringMVC/produit/modify-produit
	@PutMapping("/modify-produit")
	@ApiOperation(value = "Modifier les coordonnées d'un produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit produit) {
	return produitService.updateProduit(produit);
	}
	
	@ApiOperation(value = "affecter un fournisseur au produit.")
	@PutMapping("/assign-fournisseur/{produit}/{fournisseur}")
    @ResponseBody
    public void assignFournisseur(@PathVariable("produit") Long productId,@PathVariable("fournisseur") Long fournisseurId)
    {
        produitService.assignFournisseurToProduit(fournisseurId,productId);
    }
	
	
	@ApiOperation(value = "assgin Detail Produit To Produit")
	@GetMapping("/assignDetailProduitToProduit/{idProduit}/{idDetailProduit}")
	@ResponseBody
	public void assignDetailProduitToProduit(@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idDetailProduit") long idDetailProduit) {
		produitService.assignDetailProduitToProduit(idProduit, idDetailProduit);
	}
	
	
	
	
	
	
	
}
