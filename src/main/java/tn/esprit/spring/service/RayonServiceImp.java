package tn.esprit.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.repository.RayonRepository;

import java.util.List;

@Service
public class RayonServiceImp implements RayonService{
    @Autowired
	RayonRepository rayonRepository;

    @Override
    public void addRayon(Rayon rayon) {
        if(!rayonRepository.findById(rayon.getIdRayon()).isPresent()){
            rayonRepository.save(rayon);
        }else{
            System.out.println("Rayon existe déja");
        }
    }

    @Override
    public Rayon getRayonById(long id) {
        return rayonRepository.findById(id).get();
    }


	@Override
	public List<Rayon> getAllRayon() {
		return rayonRepository.findAll();
	}

	@Override
	public void DeleteRayon(long id) {
		rayonRepository.deleteById(id);
		
	}

	@Override
	public void DeleteAllRayon() {
		rayonRepository.deleteAll();
		
	}

	@Override
	public void UpdateRayon(Rayon rayon, long id) {
		Rayon R1 = rayonRepository.findById(id).get();
		if(rayon.getCode()!=null) R1.setCode(rayon.getCode());
		if(rayon.getLibelle()!=null) R1.setLibelle(rayon.getLibelle());
		if(rayon.getProduit()!=null) R1.setProduit(rayon.getProduit());
		
		rayonRepository.save(rayon);
	}

}
