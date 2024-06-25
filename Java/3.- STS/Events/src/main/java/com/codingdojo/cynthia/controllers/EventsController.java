package com.codingdojo.cynthia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.services.AppService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EventsController {
	
	@Autowired
	private AppService serv;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		//Validación de que el usuario inició sesión
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		
		//Obtener la lista de eventos en mi provincia
		
		//Obtener la lista de eventos en otras provincias
		
		//Enviar la lista de provincias
		
		//Enviar mi usuario
		
		return "dashboard.jsp";
	}
	
}
