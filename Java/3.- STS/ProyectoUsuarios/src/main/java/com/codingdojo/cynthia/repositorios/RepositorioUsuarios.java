package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Usuario;

//CRUD: Create Read Update Delete = Crear Leer Actualizar y Borrar
@Repository //Repositorio es el encargado de hacer las consultas
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
	
	//JPA -> Permite de manera dinámica crear queries
	
	List<Usuario> findAll(); //SELECT * FROM usuarios;
	
	//INSERT INTO usuarios (nombre, apellido...) VALUES (Atributos del objeto usuario)
	//UPDATE usuarios SET nombre = Valor de objeto....
	Usuario save(Usuario nuevoUsuario);
	//elena = Usuario("elena", "de troya", "elena@codingdojo.com", "1234"); -> Guardarla como nuevo registro
	//juana = Usuario(2, "juanita", "de arco", "juanita@codingdojo.com", "3456") -> Guardar como actualización
	
	//CrudRepository: findAll(), findById(id), save(Object obj), deleteById(id)
	
	//SELECT * FROM usuarios WHERE email = <email que recibimos en metodo>
	List<Usuario> findByEmail(String email);
	
	//SELECT * FROM usuarios WHERE nombre = <nombre que recibamos en metodo>
	List<Usuario> findByNombre(String nombre);
	
	//SELECT * FROM usuarios WHERE nombre LIKE "<letras>%"
	List<Usuario> findByNombreStartingWith(String letras);
	
	List<Usuario> findByNombreContaining(String palabra); //Pedro Pablo
	
	//SELECT * FROM usuarios ORDER BY nombre ASC
	//SELECT * FROM usuarios LIMIT 0, 10
	
}
