package com.codingdojo.cynthia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserService serv;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
						   BindingResult result,
						   HttpSession session) {
		serv.register(newUser, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			//Guardo al nuevo usuario en sesión
			session.setAttribute("userInSession", newUser);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		//Validación de que el usuario inició sesión
		return "dashboard.jsp";
	}
	
}
