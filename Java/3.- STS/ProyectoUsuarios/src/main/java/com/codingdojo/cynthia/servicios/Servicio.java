package com.codingdojo.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioSalones;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicio {
	
	@Autowired
	private RepositorioUsuarios ru;
	
	@Autowired
	private RepositorioSalones rs;
	
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
	
}
