package tn.esprit.spring.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserService;

@RestController
@Api(tags = "Client Manager")
@RequestMapping("/client")
public class UserRestController {
	
	@Autowired
    UserService userService;

	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<User> getClients() {
	List<User> listUsers = userService.retrieveAllClients();
	return listUsers;
	}
	
	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public User retrieveClient(@PathVariable("user-id") Long idUser) {
	return userService.retrieveClient(idUser);
	}
	
	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public User addClient(@RequestBody User c)
	{
	User user = userService.addClient(c);
	return user;
	}
	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{user-id}")
	@ResponseBody
	public void removeClient(@PathVariable("user-id") Long idUser) {
	userService.deleteClient(idUser);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	@ResponseBody
	public User modifyClient(@RequestBody User user) {
	return userService.updateClient(user);
	}

	@PostMapping("/login")
	@ApiOperation(value = "Login ")
	public User login(@RequestBody User user) throws Exception {
		String email=user.getEmail();
		String password=user.getPassword();
		User cl=null;
		if(email!=null && password!=null) cl = userService.doLogin(email, password);

		if(cl==null) throw new Exception("No Account to connect !");


		return cl;
	}
}
