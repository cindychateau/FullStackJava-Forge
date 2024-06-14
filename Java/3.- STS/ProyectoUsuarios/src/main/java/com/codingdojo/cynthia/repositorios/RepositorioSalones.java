package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Salon;

@Repository
public interface RepositorioSalones extends CrudRepository <Salon, Long> {
	
	List<Salon> findAll(); // SELECT * FROM salones
	
	//JPA Queries Dinámicos
	
}
