package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface DepartementService {

	public Departement addDepartement(Departement c) ;

	public void deleteDepartement(Long id);

	public List<Departement> retrieveAllDepartements() ;


	public Departement retrieveDepartement(Long id) ;


	public Departement updateDepartement(Departement u) ;

}
