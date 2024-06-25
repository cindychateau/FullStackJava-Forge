package com.codingdojo.cynthia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	//SELECT * FROM events WHERE province = <Provincia Enviada>
	List<Event> findByEventProvince(String province); //Lista de eventos en mi provincia
	
	//SELECT * FROM events WHERE province != <Provincia Enviada>
	List<Event> findByEventProvinceIsNot(String province);
	
}
