package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Client;

public interface ClientService {
	
	
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long idClient);

	Client updateClient(Client c);

	Client retrieveClient(Long idClient);

}
