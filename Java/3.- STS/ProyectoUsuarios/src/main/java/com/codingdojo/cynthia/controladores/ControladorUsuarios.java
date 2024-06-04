package com.codingdojo.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Encargada de decir que mi archivo es un controlador. Regresar el archivo jsp
public class ControladorUsuarios {

	@GetMapping("/") //Creo la ruta raíz para mi proyecto
	public String index() {
		return "index.jsp"; //Da como respuesta el archivo index.jsp
	}
	
}
