package com.codingdojo.cynthia.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controlador {
	
	@GetMapping("/Gold") //RUTA
	public String gold() {
		return "index.jsp"; //Ante la ruta /Gold muestre index.jsp
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/Gold";
	}
	
	@PostMapping("/buscar")
	public String buscar(@RequestParam("lugar") String lugar,
						 HttpSession session) {
		
		int oro = 0;
		ArrayList<String> actividades = new ArrayList<String>();
		
		if(session.getAttribute("oro") == null) {
			//NO HAY SESION AUN
			session.setAttribute("oro", 0); //Creo oro en sesión
			session.setAttribute("actividades", actividades);
		} else {
			oro = (int) session.getAttribute("oro");
			actividades = (ArrayList<String>) session.getAttribute("actividades");
		}
		
		int min = 0;
		int max = 0;
		/*Compara el lugar con distintos valores*/
		switch(lugar) {
			case "granja":
				min = 10;
				max = 20;
				break;
			case "cueva":
				min = 5;
				max = 10;
				break;
			case "casa":
				min = 2;
				max = 5;
				break;
			case "casino":
				min = -50;
				max = 50;
				break;
		}
		
		int randomNum = min + (int)(Math.random() * ((max - min) + 1));
		oro += randomNum;
		session.setAttribute("oro", oro); //Actualizando la puntuación
		
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("MMMM d Y h:mm a");
		String fechaFormateada = formato.format(fecha);
		
		String mensaje = "";
		
		if(randomNum < 0) {
			mensaje = "Entraste a: "+lugar+" y perdiste "+randomNum+" ¡Ouch! "+fechaFormateada;
		} else {
			mensaje = "Entraste a: "+lugar+" y ganaste "+randomNum+" WUJUU! "+fechaFormateada;
		}
		
		actividades.add(mensaje);
		session.setAttribute("actividades", actividades);
		
		return "redirect:/Gold";
	}
	
}
