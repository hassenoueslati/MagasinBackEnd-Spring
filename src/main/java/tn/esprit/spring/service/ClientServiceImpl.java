package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientRepository clientRepository ;
	
	@Override
	public List<Client> retrieveAllClients() {
           List<Client>clients= (List<Client>)clientRepository.findAll();

           return clients ;
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long idClient) {
      clientRepository.deleteById(idClient);		
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long idClient) {
		return clientRepository.findById(idClient).get();
	}
	
	

}
