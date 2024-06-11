package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicio;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorAPI {
	
	@Autowired //Me permite llamar a mi clase sin instanciarla
	private Servicio serv;
	
	@GetMapping("/") // /api/usuarios/
	public List<Usuario> apiMuestraUsuarios() {
		return serv.todosUsuarios();
	}
	
	@PostMapping("/")
	public Usuario apiCrearUsuario(@RequestParam("nombre") String nombre,
								   @RequestParam("apellido") String apellido,
								   @RequestParam("email") String email,
								   @RequestParam("password") String password) {
		
		Usuario nuevoUsuario = new Usuario(nombre, apellido, email, password); //Creo la instancia de Usuario
		return serv.guardarUsuario(nuevoUsuario);
		
	}
	
}
