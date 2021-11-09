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

import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.service.DetailProduitServiceImpl;

@RestController
@RequestMapping("/detailProduit")
public class DetailProduitRestController {
	@Autowired
	DetailProduitServiceImpl detailProduitService ; 
	
	// http://localhost:8089/SpringMVC/detailproduit/retrieve-all-detailproduits
		@GetMapping("/retrieve-all-detailproduits")
		@ResponseBody
		public List<DetailProduit> getDetailProduits() {
			List<DetailProduit> listDetailProduits = detailProduitService.retrieveAllDetailProduit();
			return listDetailProduits ;
		}
		
		// http://localhost:8089/SpringMVC/detailproduit/retrieve-detailproduit/8
		@GetMapping("/retrieve-detailproduit/{detailproduit-id}")
		@ResponseBody
		public DetailProduit retrieveDetailProduit(@PathVariable("detailproduit-id") Long idDetailProduit) {
		return detailProduitService.retrieveDetailProduit(idDetailProduit);
		}
		
		// http://localhost:8089/SpringMVC/detailproduit/add-detailproduit
		@PostMapping("/add-detailproduit")
		@ResponseBody
		public DetailProduit addDetailProduit(@RequestBody DetailProduit dp)
		{
			DetailProduit detailProduit = detailProduitService.addDetailProduit(dp);
		return detailProduit;
		}
		
		// http://localhost:8089/SpringMVC/detailproduit/remove-produit/{detailproduit-id}
		@DeleteMapping("/remove-detailproduit/{detailproduit-id}")
		@ResponseBody
		public void removeDetailProduit(@PathVariable("detailproduit-id") Long idDetailProduit) {
			detailProduitService.deleteDetailProduit(idDetailProduit);
		}
		
		// http://localhost:8089/SpringMVC/detailproduit/modify-detailproduit
		@PutMapping("/modify-detailproduit")
		@ResponseBody
		public DetailProduit modifyDetailProduit(@RequestBody DetailProduit detailProduit) {
		return detailProduitService.updateDetailProduit(detailProduit);
		}
		
		
		
}
