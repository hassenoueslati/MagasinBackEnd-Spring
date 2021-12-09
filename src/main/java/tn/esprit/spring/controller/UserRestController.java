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
@Api(tags = "User Manager")
@CrossOrigin(origins = "*")
@RequestMapping("/User")
public class UserRestController {
	
	@Autowired
    UserService userService;


	// http://localhost:8089/SpringMVC/User/getUser
	@GetMapping("/getUser")
	@CrossOrigin(origins = "http://localhost:63374")
	@ApiOperation(value = "Get All Users ")
	@ResponseBody
	public List<User> getClients() {
	List<User> listUsers = userService.retrieveAllClients();
	return listUsers;
	}

	@GetMapping("/retrieveUserByCategory/{categoryClient}")
	@ApiOperation(value = "Retrieve User By Category ")
	@ResponseBody
	public List<User> getClientsByCategory(@PathVariable("categoryClient") CategorieClient categoryClient) {
		List<User> user = userService.getUserByCategorieClient(categoryClient);
		return user ;

	}
	
	// http://localhost:8089/SpringMVC/User/retrieve-client/8
	@GetMapping("/retrieveUser/{user-id}")
	@ApiOperation(value = "Retrieve User ")
	@ResponseBody
	public User retrieveClient(@PathVariable("user-id") Long idUser) {
	return userService.retrieveClient(idUser);
	}
	
	// http://localhost:8089/SpringMVC/User/add-client
	@PostMapping("/addUser")
	@ApiOperation(value = "Add User ")
	public User addClient(@RequestBody User c)
	{
	User user = userService.addClient(c);
	return user;
	}
	// http://localhost:8089/SpringMVC/User/remove-client/{client-id}
	@DeleteMapping("/removeUser/{user-id}")
	@ApiOperation(value = "Remove User ")
	@ResponseBody
	public void removeClient(@PathVariable("user-id") Long idUser) {
	userService.deleteClient(idUser);
	}

	// http://localhost:8089/SpringMVC/User/modify-client
	@PutMapping("/modifyUser")
	@ApiOperation(value = "Modify User ")

	@ResponseBody
	public User modifyClient(@RequestBody User user) {
	return userService.updateClient(user);
	}

	// http://localhost:8089/SpringMVC/User/login
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
	public User getUserByEmail(@PathVariable("email")String email){
		return userService.getUserByEmail(email);
	}
}
