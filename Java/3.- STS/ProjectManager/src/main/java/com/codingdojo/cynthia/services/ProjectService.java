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
		return pr.findByJoinedUsersContainsOrderByDueDate(user);
	}
	
	public List<Project> findOtherProjects(User user){
		return pr.findByJoinedUsersNotContains(user);
	}
	
	/*Método que me regrese un usuario en base al id*/
	public User findUser(Long id) {
		return ur.findById(id).orElse(null);
	}
	
	/*Método que me regresa un proyecto en base al id*/
	public Project findProject(Long id) {
		return pr.findById(id).orElse(null);
	}
	
	public void joinProject(Long userId, Long projectId) {
		User myUser = findUser(userId); //Objeto de usuario con userId que recibio
		Project projectToJoin = findProject(projectId); //Objeto project con projectIdå
		
		projectToJoin.getJoinedUsers().add(myUser);
		pr.save(projectToJoin);
	}
	
	public void leaveProject(Long userId, Long projectId) {
		User myUser = findUser(userId); //Objeto de usuario con userId que recibio
		Project projectToJoin = findProject(projectId); //Objeto project con projectIdå
		
		projectToJoin.getJoinedUsers().remove(myUser);
		pr.save(projectToJoin);
	}
}
