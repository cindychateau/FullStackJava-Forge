package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Hobby;

@Repository
public interface RepositorioHobbies extends CrudRepository<Hobby, Long> {
	
	List<Hobby> findAll(); //findAll objeto iterable. Forzo a que sea una LISTA
	
}
