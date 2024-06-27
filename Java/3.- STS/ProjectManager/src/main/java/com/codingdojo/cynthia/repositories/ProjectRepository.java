package com.codingdojo.cynthia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.models.Project;
import com.codingdojo.cynthia.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	//SELECT * FROM projects JOIN users_has_projects ON users_has_projects.project_id = projects.id WHERE users_has_projects.user_id != usuario
	//Lista de proyectos que incluyan un usuario
	List<Project> findByJoinedUsersContains(User user);  
	
	//Lista de proyectos que NO incluyan al usuario
	List<Project> findByJoinedUsersNotContains(User user);
	
}
