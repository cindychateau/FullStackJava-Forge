package com.codingdojo.cynthia.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	//Consulta que me regrese un User en base a su email
	User findByEmail(String email);
	
}
