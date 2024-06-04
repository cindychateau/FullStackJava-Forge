package com.codingdojo.cynthia.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Encargada de decir que mi archivo es un controlador. Regresar el archivo jsp
public class ControladorUsuarios {

	@GetMapping("/") //Creo la ruta raíz para mi proyecto
	public String index() {
		return "index.jsp"; //Da como respuesta el archivo index.jsp
	}
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		//Model me permite enviar información de la función hacia el jsp
		
		model.addAttribute("titulo", "¡Bienvenid@ al inicio de JSTL");
		
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo"};
		model.addAttribute("listaUsuarios", usuarios);
		
		HashMap<String, String> paises = new HashMap<String, String>();
		paises.put("Mexico", "CDMX");
		paises.put("El Salvador", "San Salvador");
		paises.put("Argentina", "Buenos Aires");
		
		model.addAttribute("paises", paises);
		
		return "inicio.jsp";
	}
	
}