package com.codingdojo.cynthia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectsController {
	
	@Autowired
	private UserService serv;
	
	//PEND: Servicio de projects
	
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		//Validación de que el usuario inició sesión
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		
		return "dashboard.jsp";
	}
	
	
}
