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

import com.codingdojo.cynthia.models.Event;
import com.codingdojo.cynthia.models.Message;
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
		List<Event> eventsNear = serv.getEventsNear(myUser.getProvince());
		model.addAttribute("eventsNear", eventsNear);
		
		//Obtener la lista de eventos en otras provincias
		List<Event> eventsNotNear = serv.getEventsNotNear(myUser.getProvince());
		model.addAttribute("eventsNotNear", eventsNotNear);
		
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
			List<Event> eventsNear = serv.getEventsNear(myUser.getProvince());
			model.addAttribute("eventsNear", eventsNear);
			
			//Obtener la lista de eventos en otras provincias
			List<Event> eventsNotNear = serv.getEventsNotNear(myUser.getProvince());
			model.addAttribute("eventsNotNear", eventsNotNear);
			
			//Enviar la lista de provincias
			model.addAttribute("provinces", Province.Provinces);
			
			return "dashboard.jsp";
		} else {
			serv.saveEvent(newEvent);
			return "redirect:/dashboard";
		}
		
		
	}
	
	@GetMapping("/join/{eventId}")
	public String join(@PathVariable("eventId") Long eventId,
					   HttpSession session) {
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/* === REVISAMOS SESION === */
		
		serv.joinEvent(userTemp.getId(), eventId);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/cancel/{eventId}")
	public String cancel(@PathVariable("eventId") Long eventId,
						 HttpSession session) {
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/* === REVISAMOS SESION === */
		
		serv.cancelEvent(userTemp.getId(), eventId);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/event/{id}")
	public String event(@PathVariable("id") Long id,
						HttpSession session,
						Model model,
						@ModelAttribute("message") Message message) {
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/* === REVISAMOS SESION === */
		
		Event event = serv.getEvent(id);
		model.addAttribute("event", event);
		
		return "event.jsp";
	}
	
	@PostMapping("/create_message")
	public String createMessage(@Valid @ModelAttribute("message") Message message,
								BindingResult result,
								HttpSession session,
								Model model) {
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		/* === REVISAMOS SESION === */
		
		if(result.hasErrors()) {
			model.addAttribute("event", message.getEvent());
			return "event.jsp";
		} else {
			serv.saveMessage(message);
			return "redirect:/event/"+message.getEvent().getId();
		}
	}
	
	
}