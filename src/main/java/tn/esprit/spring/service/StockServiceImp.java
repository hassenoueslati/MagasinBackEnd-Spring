package tn.esprit.spring.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;
@Slf4j
@Service
public class StockServiceImp implements StockService {
	
	@Autowired
	StockRepository stockRepository ;
	
	@Autowired
	ProduitRepository produitRepository;
	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		// TODO Auto-generated method stub
		
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long idStock) {
		// TODO Auto-generated method stub
		return stockRepository.findById(idStock).get();
	}
	
	
	

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		// TODO Auto-generated method stub
		Produit prod=produitRepository.findById(idProduit).get();
		prod.setStock(stockRepository.findById(idStock).get());
		produitRepository.save(prod);
		
	}

	@Override
	public void deleteStock(long idStock) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(idStock);
	}

	
	
}
