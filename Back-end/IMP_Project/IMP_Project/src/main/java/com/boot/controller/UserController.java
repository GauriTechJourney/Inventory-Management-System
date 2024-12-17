package com.boot.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.User;
import com.boot.service.UserService;



@RestController
@CrossOrigin
@RequestMapping("/api/User")
public class UserController {
	
	@Autowired
	private UserService uServ;
	
	@PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
		
		return uServ.addUser(user);
	}
	
	@GetMapping("/login/{email}/{password}")
	public User showLogin(@PathVariable String email, @PathVariable String password) {
		return uServ.showLogin(email, password);
	}
	
	@GetMapping("/login/{email}/{password}/{role}")
	public User showLogin(@PathVariable String email, @PathVariable String password, @PathVariable String role)
	{
		return uServ.showLoginWithRole(email, password,role);
	}

	@GetMapping("/show-all")
	public List<User> showAll(){
		return uServ.showAll();
	}

}
