package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl implements DetailProduitService {

	@Autowired
	DetailProduitRepository detailProduitRepository ;
	@Override
	public List<DetailProduit> retrieveAllDetailProduit() {
		return (List<DetailProduit>) detailProduitRepository.findAll() ;
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit dp) {
		return detailProduitRepository.save(dp);
	}

	@Override
	public void deleteDetailProduit(Long id) {
		detailProduitRepository.deleteById(id);
		
	}

	@Override
	public DetailProduit updateDetailProduit(DetailProduit dp) {
		return detailProduitRepository.save(dp);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		return detailProduitRepository.findById(id).get();
	}

	
}
