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

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.service.ReclamationServiceImp;
import tn.esprit.spring.service.StockService;
import tn.esprit.spring.service.StockServiceImp;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockServiceImp stockService ;
	
	// http://localhost:8089/SpringMVC/stock/retrieve-all-Stock
	@GetMapping("/retrieve-all-Stocks")
	@ResponseBody
	public List<Stock> getAllStock(){
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;
	}
	
	// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveClient(@PathVariable("stock-id") Long idStock) {
	return stockService.retrieveStock(idStock);
	}
	
	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s)
	{
		Stock stock = stockService.addStock(s);
	return stock;
	}
	
	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long idStock) {
		stockService.deleteStock(idStock);
	}

	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
	return stockService.updateStock(stock);
	}
}
