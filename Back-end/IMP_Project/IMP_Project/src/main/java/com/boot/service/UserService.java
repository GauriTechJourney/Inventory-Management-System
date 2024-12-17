package com.boot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.User;
import com.boot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public User addUser(User user) {
		System.out.println("\n Add user method!!");
		
		
		return uRepo.save(user);
	}
	
	public User showLogin(String email, String password) {
		
		User user = uRepo.findByEmailAndPassword(email, password);
		return user;
	}
	
   public User showLoginWithRole(String email, String password,String role) {
		
		User user = uRepo.findByEmailAndPasswordAndRole(email, password,role);
		return user;
	}

	public List<User> showAll(){
		return uRepo.findAll();
	}


}
