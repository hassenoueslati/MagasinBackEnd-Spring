package tn.esprit.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.service.ProduitService;
import tn.esprit.spring.service.RayonServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Rayon")
@Api(tags = "Rayon Manager")
@CrossOrigin(origins = "*")
public class RayonController {

	@Autowired
	RayonServiceImp R;

	public RayonController(RayonServiceImp R) {
		this.R=R;
	}
	
	@PostMapping("/AddRayon")
	public String AddRayon(Rayon rayon){
		R.addRayon(rayon);
		return("Rayon add don !!");
	}
	
	@PostMapping("/DeleteRayon/{id}")
	public String DeleteRayonByID (@PathVariable long id) {
		R.DeleteRayon(id);
		String s;
		s="Rayon " + id + " is deleted successfully";
		return s; 
	}
	
	@PostMapping("/DeleteAllRayon")
	public String DeleteAllRayon() {
		R.DeleteAllRayon();
		return "All Rayon are deleted successfully !!";
	}
	
	@GetMapping("{id}")
	public Rayon FindRayonByID(@PathVariable long id) {
		return R.getRayonById(id);
		
	}
	
	@GetMapping("/AllRayon")
	public List<Rayon> FindAllRayon() {
		return R.getAllRayon();
	}

	@ApiOperation(value = "Mettre a jour un rayon")
	@PutMapping("/modifyRayon")
	@ResponseBody
	public Rayon modifyRayon(@RequestBody Rayon ray) {
		return R.UpdateRayon(ray);
	}

	@ApiOperation(value = "assignProduitToRayon")
	@GetMapping("/assignProduitToStock/{idProduit}/{idRayon}")
	@ResponseBody
	public void assignProduitToRayon(@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idRayon") long idRayon) {
		 R.assignProduitToRayon(idProduit, idRayon);
	}
}

