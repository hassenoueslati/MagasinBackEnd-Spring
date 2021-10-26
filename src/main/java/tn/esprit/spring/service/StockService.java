package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Stock;

public interface StockService {
	List<Stock> retrieveAllStocks();
    Stock addStock(Stock s);
    Stock updateStock(Stock u);
    Stock retrieveStock(Long idStock);
    
}
