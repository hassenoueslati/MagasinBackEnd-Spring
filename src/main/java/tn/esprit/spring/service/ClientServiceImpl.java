package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientRepository clientRepository ;
	
	@Override
	public List<Client> retrieveAllClients() {
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
      clientRepository.deleteById(id);		
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		return clientRepository.findById(id).get();
	}
	
	public List<Client> SQLretrieveAllClientsByBirthDate(Date D1 , Date D2) {
        return  (List<Client>)clientRepository.SQLretrieveClientsByBirthDate(D1, D2);
    }
    public List<Client> JPQLretrieveAllClientsByBirthDate(Date D1 , Date D2) {
        return  (List<Client>)clientRepository.JPQLretrieveClientsByBirthDate(D1, D2);
    }

}
