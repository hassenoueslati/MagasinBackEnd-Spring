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

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.ReclamationServiceImp;
import tn.esprit.spring.service.StockService;
import tn.esprit.spring.service.StockServiceImp;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockService stockService ;
	@Autowired
	StockRepository stockRepository ;
	
	// http://localhost:8089/SpringMVC/stock/retrieveAllStocks
	@GetMapping("/retrieveAllStocks")
	@ApiOperation("trouver tous les stocks")
	public List<Stock> getAllStock(){
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;
	}
	
	// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
	@GetMapping("/retrieve-stock/{stock-id}")
	@ApiOperation("trouver un stock")
	@ResponseBody
	public Stock retrieveClient(@PathVariable("stock-id") Long idStock) {
	return stockService.retrieveStock(idStock);
	}
	
	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ApiOperation("ajouter les stocks")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s)
	{
		Stock stock = stockService.addStock(s);
	return stock;
	}
	
	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")
	@ApiOperation("supprimer les stocks")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long idStock) {
		stockService.deleteStock(idStock);
	}

	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock/{id}")
	@ApiOperation("modifier les stocks")

	public Stock modifyStock(@RequestBody Stock stock,@PathVariable long id) {
	Stock st=stockService.retrieveStock(id);
	if(stock.getLibelleStock()!=null) st.setLibelleStock(stock.getLibelleStock());
	if(stock.getQte()!=0) st.setQte(stock.getQte());
	if(stock.getQteMin()!=0)st.setQteMin(stock.getQteMin());
	return stockService.updateStock(st);
	}
	@GetMapping(value = "/search/{keyword}")
    public List<Stock> dynamicSearch(@PathVariable String keyword){
		return stockRepository.search(keyword);
   	 
    }
	
	@GetMapping("/assignProduitToStock/{idProduit}/{idStock}")
	public String assinProduitToStock(@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idStock") long idStock) {
		stockService.assignProduitToStock(idProduit, idStock);
		return "product successfuly assigned to Stock";
	}

}
