package com.codingdojo.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Hobby;
import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioHobbies;
import com.codingdojo.cynthia.repositorios.RepositorioSalones;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicio {
	
	@Autowired
	private RepositorioUsuarios ru;
	
	@Autowired
	private RepositorioSalones rs;
	
	@Autowired
	private RepositorioHobbies rh;
	
	//Método que me regrese todos los usuarios
	public List<Usuario> todosUsuarios(){
		return ru.findAll();
	}
	
	//Método que guarde usuarios (nuevo registros como actualizaciones)
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		return ru.save(nuevoUsuario);
	}
	
	//Método que regresa un objeto usuario en base a su id
	public Usuario buscarUsuario(Long id) {
		return ru.findById(id).orElse(null);
	}
	
	//Método que borre en base al id
	public void borrarUsuario(Long id) {
		ru.deleteById(id);
	}
	
	public List<Salon> todosSalones() {
		return rs.findAll();
	}
	
	//Método que me regrese la lista de hobbies
	public List<Hobby> todosHobbies() {
		return rh.findAll();
	}
	
	//Método que me regrese UN hobby específico en base a su id
	public Hobby buscarHobby(Long id) {
		return rh.findById(id).orElse(null);
	}
	
	//Método que asigne un hobby a un usuario
	public void guardarUsuarioHobby(Long usuarioId, Long hobbyId) {
		//Obtener el objeto de usuario al que le agregamos el hobby
		Usuario miUsuario = buscarUsuario(usuarioId);
		
		//Obtener el objeto de hobby que se va a asignar
		Hobby miHobby = buscarHobby(hobbyId);
		
		miUsuario.getHobbies().add(miHobby);
		ru.save(miUsuario);
		
		//miHobby.getUsuarios().add(miUsuario);
		//rh.save(miHobby);
		
		
	}
	
	//Método que quite un hobby a un usuario
	public void quitarUsuarioHobby(Long usuarioId, Long hobbyId) {
		//Obtener el objeto de usuario al que le agregamos el hobby
		Usuario miUsuario = buscarUsuario(usuarioId);
		
		//Obtener el objeto de hobby que se va a asignar
		Hobby miHobby = buscarHobby(hobbyId);
		
		miUsuario.getHobbies().remove(miHobby);
		ru.save(miUsuario);
	}
	
}
