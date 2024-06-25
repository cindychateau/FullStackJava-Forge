package com.codingdojo.cynthia.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
