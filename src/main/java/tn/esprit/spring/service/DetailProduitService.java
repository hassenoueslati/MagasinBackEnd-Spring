package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.DetailProduit;

public interface DetailProduitService {

	List<DetailProduit> retrieveAllDetailProduit();

	DetailProduit addDetailProduit(DetailProduit dp);

	void deleteDetailProduit(Long idDetailProduit);

	DetailProduit updateDetailProduit(DetailProduit dp);

	DetailProduit retrieveDetailProduit(Long idDetailProduit);
}
