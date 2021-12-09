package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;


@Slf4j
@Service
public class DepartementServiceImpl  implements DepartementService {
	@Autowired
	 DepartementRepository departementRepository;
		
//------------------------------------------------------------
	@Override
	public Departement addDepartement(Departement c) {
		departementRepository.save(c);
		return c;
	}
//------------------------------------------------------------	

	@Override
	public void deleteDepartement(Long id) {
		departementRepository.deleteById(id);
	}
//------------------------------------------------------------	

	
	@Override
	public List<Departement> retrieveAllDepartements() {
			
		return (List<Departement>)this.departementRepository.findAll() ;
	}
//------------------------------------------------------------	

	@Override
	public Departement retrieveDepartement(Long id) {
		return this.departementRepository.findById(id).get();
	}
//------------------------------------------------------------	

	@Override
	public Departement updateDepartement(Departement u) {
		
		this.departementRepository.save(u);
		return u;
	}
}
