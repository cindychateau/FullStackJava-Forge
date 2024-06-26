package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.cynthia.modelos.Hobby;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicio;

@Controller
public class ControladorHobbies {
	
	@Autowired
	private Servicio serv;
	
	@GetMapping("/asignar/{id}")
	public String asignar(@PathVariable("id") Long id,
						  Model model) {
		//Usuario al que le voy a asignar los hobbies
		Usuario miUsuario = serv.buscarUsuario(id);
		model.addAttribute("usuario", miUsuario); //model.addAttribute("user", myUser);
		
		//Lista de Hobbies
		List<Hobby> hobbies = serv.todosHobbies();
		model.addAttribute("hobbies", hobbies);
		
		return "asignar.jsp"; //va a poner accesar a usuario = OBJ
	}
	
	@GetMapping("/asignarHobby/{usuarioId}/{hobbyId}")
	public String asignarHobby(@PathVariable("usuarioId") Long usuarioId,
							   @PathVariable("hobbyId") Long hobbyId) {
		
		//Invocar a un método que haga la asignación
		serv.guardarUsuarioHobby(usuarioId, hobbyId);
		
		return "redirect:/dashboard"; //asignar/id
		
	}
	
	@GetMapping("/quitarHobby/{usuarioId}/{hobbyId}")
	public String quitarHobby(@PathVariable("usuarioId") Long usuarioId,
							   @PathVariable("hobbyId") Long hobbyId) {
		
		//Invocar a un método que haga la asignación
		serv.quitarUsuarioHobby(usuarioId, hobbyId);
		
		return "redirect:/dashboard"; //asignar/id
		
	}
	
}
