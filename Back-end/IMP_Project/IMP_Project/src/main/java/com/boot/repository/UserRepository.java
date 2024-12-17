package com.boot.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmailAndPassword(String email, String password);

	User findByEmailAndPasswordAndRole(String email, String password, String role);

}
