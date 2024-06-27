package com.codingdojo.cynthia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	@GetMapping("/projects/join/{id}") // /projects/join/1 1= id del proyecto
	public String projectJoin(@PathVariable("id") Long id,
							  HttpSession session) {
		/*REVISION DE SESION*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/*REVISION DE SESION*/
		
		//Invocar una función que dado un id de proyecto y un id de usuario, los una
		ps.joinProject(userTemp.getId(), id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/leave/{id}")
	public String projectLeave(@PathVariable("id") Long id,
							   HttpSession session) {
		/*REVISION DE SESION*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/*REVISION DE SESION*/
		
		ps.leaveProject(userTemp.getId(), id);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/edit/{id}")
	public String projectEdit(@PathVariable("id") Long id,
							HttpSession session,
							@ModelAttribute("project") Project project, /*Generar un objeto vacío*/
							Model model) {
		/*REVISION DE SESION*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/*REVISION DE SESION*/
		
		//Obtener el objeto de Project
		Project projectToEdit = ps.findProject(id);
		
		//Medida de seguridad extra
		if(userTemp.getId() != projectToEdit.getLead().getId()) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("project", projectToEdit); //Objeto que SI tiene info del proyecto
		return "edit.jsp";
		
	}
	
	@PutMapping("/projects/update")
	public String projectUpdate(HttpSession session,
								@Valid @ModelAttribute("project") Project project, /*Objeto si tiene info*/
								BindingResult result) {
		/*REVISION DE SESION*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/*REVISION DE SESION*/
		
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			//Debemos de agregar de nuevo los usuarios que se unieron al proyecto
			//project -> Objeto basado en el formulario.  thisProject -> Objeto extraido de BD
			Project thisProject = ps.findProject(project.getId());
			List<User> usersJoinedInProject = thisProject.getJoinedUsers(); //Lista de usuarios que se unieron al proyecto
			project.setJoinedUsers(usersJoinedInProject);
			
			//Guardamos proyecto
			ps.saveProject(project);
			return "redirect:/dashboard";
		}
		
	}
	
}
