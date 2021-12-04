package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.User;

public interface UserService {
	
	
	List<User> retrieveAllClients();

	User addClient(User c);

	void deleteClient(Long id);

	User updateClient(User c);

	User retrieveClient(Long id);

	Boolean getUserByEmailAndPassword(String email,String Password);
	User getUserByEmail(String email);
	List<User> getUserByCategorieClient(CategorieClient categorieClient);

	User doLogin(String email, String Password) ;

}
