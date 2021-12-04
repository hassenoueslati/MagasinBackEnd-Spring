package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repository.DetailFactureRepository;
@Slf4j
@Service
public class DetailFactureServiceImpl  implements DetailFactureService{

	@Autowired
	DetailFactureRepository DetailFactureRepository ;
	
	@Override
	public List<DetailFacture> retrieveAllDetailFacture() {
		return (List<DetailFacture>) DetailFactureRepository.findAll();
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture d) {
		return DetailFactureRepository.save(d);
	}

	@Override
	public void deleteDetailFacture(Long id) {
		DetailFactureRepository.deleteById(id);		
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture d) {
		return DetailFactureRepository.save(d);
	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		return DetailFactureRepository.findById(id).get();
	}

	

}
