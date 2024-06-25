package com.codingdojo.cynthia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cynthia.models.Event;
import com.codingdojo.cynthia.models.Province;
import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.services.AppService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventsController {
	
	@Autowired
	private AppService serv;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,
							@ModelAttribute("newEvent") Event newEvent, /*Objeto vacío para form:form*/
							Model model /*Enviar info de método al jsp */ ) {
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/* === REVISAMOS SESION === */
		
		//Enviar mi usuario
		User myUser = serv.getUser( userTemp.getId() );
		model.addAttribute("user", myUser);
		
		//Obtener la lista de eventos en mi provincia
		
		//Obtener la lista de eventos en otras provincias
		
		//Enviar la lista de provincias
		model.addAttribute("provinces", Province.Provinces);
		
		
		
		return "dashboard.jsp";
	}
	
	@PostMapping("/create_event")
	public String createEvent(HttpSession session, /*Persistencia de datos*/
							  @Valid @ModelAttribute("newEvent") Event newEvent, /*Obj Event con info del form:form*/
							  BindingResult result, /*Genera mensajes de error*/
							  Model model) { /*Enviar info de método al jsp */
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/* === REVISAMOS SESION === */
		
		if(result.hasErrors()) {
			//Enviar mi usuario
			User myUser = serv.getUser( userTemp.getId() );
			model.addAttribute("user", myUser);
			
			//Obtener la lista de eventos en mi provincia
			
			//Obtener la lista de eventos en otras provincias
			
			//Enviar la lista de provincias
			model.addAttribute("provinces", Province.Provinces);
			
			return "dashboard.jsp";
		} else {
			serv.saveEvent(newEvent);
			return "redirect:/dashboard";
		}
		
		
	}
	
}
