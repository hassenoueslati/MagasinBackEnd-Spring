package tn.esprit.spring.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;

import java.util.List;

@Slf4j
@Service
public class RayonServiceImp implements RayonService{
    @Autowired
	RayonRepository rayonRepository;
	@Autowired
	ProduitRepository produitRepository;

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
	@Override
	public void assignProduitToRayon(Long idProduit, Long idRayon) {
		Produit prod=produitRepository.findById(idProduit).get();
		prod.setRayon(rayonRepository.findById(idRayon).get());
		produitRepository.save(prod);
	}
	@Scheduled(cron = "0 10 * * 1")
	public String retreiveRayonStatus() {
		rayonRepository.getStatusRayon().forEach(rayon -> {
			log.warn("rayon "+rayon.getLibelle() +"est vide");
		});
		return "";
	}

}
