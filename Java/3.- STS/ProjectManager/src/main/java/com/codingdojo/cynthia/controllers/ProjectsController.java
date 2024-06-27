package com.codingdojo.cynthia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cynthia.models.Project;
import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.services.ProjectService;
import com.codingdojo.cynthia.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectsController {
	
	@Autowired
	private UserService serv;
	
	@Autowired
	private ProjectService ps;
	
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,
							Model model) {
		/*REVISION DE SESION*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/*REVISION DE SESION*/
		
		//Lista de proyectos a los que se unió mi usuario
		model.addAttribute("myProjects", ps.findMyProjects(userTemp));
		
		//Lista de proyectos a los que no se unió mi usuario
		model.addAttribute("otherProjects", ps.findOtherProjects(userTemp));
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/projects/new")
	public String projectNew(HttpSession session,
							 @ModelAttribute("project") Project project) {
		/*REVISION DE SESION*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/*REVISION DE SESION*/
		
		return "new.jsp";
		
	}
	
	@PostMapping("/projects/create")
	public String projectCreate(@Valid @ModelAttribute("project") Project project,
								BindingResult result,
								HttpSession session) {
		/*REVISION DE SESION*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/*REVISION DE SESION*/
		
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			ps.saveProject(project);
			
			//Agregar el proyecto nuevo a la lista de mis proyectos unidos
			User myUser = serv.findUser(userTemp.getId());
			myUser.getJoinedProjects().add(project);
			serv.saveUser(myUser);
			return "redirect:/dashboard";
		}
	}
	
	
}
