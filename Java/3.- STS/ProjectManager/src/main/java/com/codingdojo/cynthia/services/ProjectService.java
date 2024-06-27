package com.codingdojo.cynthia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.models.Project;
import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.repositories.ProjectRepository;
import com.codingdojo.cynthia.repositories.UserRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository pr;
	
	@Autowired
	private UserRepository ur;
	
	public Project saveProject(Project newProject){
		return pr.save(newProject);
	}
	
	/*Método que regresa los proyectos en los que mi usuario se unió*/
	public List<Project> findMyProjects(User user){
		return pr.findByJoinedUsersContains(user);
	}
	
	public List<Project> findOtherProjects(User user){
		return pr.findByJoinedUsersNotContains(user);
	}
}
