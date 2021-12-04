package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> retrieveAllClients() {
           List<User> users = (List<User>) userRepository.findAll();

           return users;
	}

	@Override
	public User addClient(User c) {
		return userRepository.save(c);
	}

	@Override
	public void deleteClient(Long idUser) {
      userRepository.deleteById(idUser);
	}

	@Override
	public User updateClient(User c) {
		return userRepository.save(c);
	}

	@Override
	public User retrieveClient(Long idUser) {
		return userRepository.findById(idUser).get();
	}

	@Override
	public Boolean getUserByEmailAndPassword(String email, String Password) {
		if(userRepository.getUserByEmailAndPassword(email,Password)!=null) return true;
		return false;
	}
	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

	@Override
	public List<User> getUserByCategorieClient(CategorieClient categorieClient){
		return userRepository.getUserByCategorieClient(categorieClient);
	}



	@Override
	public User doLogin(String email, String Password) {
		return userRepository.getUserByEmailAndPassword(email,Password);
	}




}
