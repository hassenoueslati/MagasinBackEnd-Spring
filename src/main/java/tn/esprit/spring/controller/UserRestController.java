package tn.esprit.spring.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserService;

@RestController
@Api(tags = "Client Manager")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/User")
public class UserRestController {
	
	@Autowired
    UserService userService;


	// http://localhost:8089/SpringMVC/User/getUser
	@GetMapping("/getUser")
	@ResponseBody
	public List<User> getClients() {
	List<User> listUsers = userService.retrieveAllClients();
	return listUsers;
	}

	@GetMapping("/retrieveUserByCategory/{categoryClient}")
	@ResponseBody
	public List<User> getClientsByCategory(@PathVariable("categoryClient") CategorieClient categoryClient) {
		List<User> user = userService.getUserByCategorieClient(categoryClient);
		return user ;

	}
	
	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieveUser/{user-id}")
	@ResponseBody
	public User retrieveClient(@PathVariable("user-id") Long idUser) {
	return userService.retrieveClient(idUser);
	}
	
	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/addUser")
	@ResponseBody
	public User addClient(@RequestBody User c)
	{
	User user = userService.addClient(c);
	return user;
	}
	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/removeUser/{user-id}")
	@ResponseBody
	public void removeClient(@PathVariable("user-id") Long idUser) {
	userService.deleteClient(idUser);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modifyUser")
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


	@RequestMapping(value = "/log/{email}", method = RequestMethod.GET)
	public User getUserByEmailPassword(@PathVariable("email")String email){
		return userService.getUserByEmail(email);
	}
}
