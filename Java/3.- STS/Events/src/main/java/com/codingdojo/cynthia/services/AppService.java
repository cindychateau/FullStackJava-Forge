package com.codingdojo.cynthia.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.cynthia.models.Event;
import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.repositories.EventRepository;
import com.codingdojo.cynthia.repositories.MessageRepository;
import com.codingdojo.cynthia.repositories.UserRepository;

@Service
public class AppService {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private EventRepository er;
	
	@Autowired
	private MessageRepository mr;
	
	/*Método que registre a un nuevo usuario*/
	public User register(User newUser, BindingResult result) {
		
		//Comparar las contraseñas
		String password = newUser.getPassword();
		String confirm = newUser.getConfirm();
		if(!password.equals(confirm)) {
			//SI no son iguales
			//path, clave, mensaje
			result.rejectValue("confirm", "Matches", "Password and confirmation don't match");
		}
		
		//Revisar que el email no esté registrado
		String email = newUser.getEmail();
		User userExist = ur.findByEmail(email); //Objeto de User o null
		if(userExist != null) {
			//El correo ya está registrado
			result.rejectValue("email", "Unique", "E-mail already exists");
		}
		
		//Si existe error, regreso null
		if(result.hasErrors()) {
			return null;
		} else {
			//NO HAY ERRORES
			//Hashear contraseña
			String passHash = BCrypt.hashpw(password, BCrypt.gensalt());
			newUser.setPassword(passHash); //Establecemos el password hasheado
			return ur.save(newUser);
		}
		
	}
	
	/*Método que revisa que los datos sean correctos para Iniciar Sesión*/
	public User login(String email, String password) {
		//Revisamos que el correo exista en BD
		User userTryingLogin = ur.findByEmail(email); //Objeto User o NULL
		
		if(userTryingLogin == null) {
			return null;
		}
		
		//Comparar las contraseñas
		//BCrypt.checkpw(Contra NO encriptada, Contra SI encriptada) -> True o False
		if(BCrypt.checkpw(password, userTryingLogin.getPassword())) {
			return userTryingLogin;
		} else {
			return null;
		}
		
		
	}
	
	public Event saveEvent(Event newEvent) {
		return er.save(newEvent);
	}
	
	/* Método que en base a un id nos regresa un objeto de User */
	public User getUser(Long id) {
		return ur.findById(id).orElse(null);
	}
	
	/*Método que regresa una lista de Event de una provincia*/
	public List<Event> getEventsNear(String province) {
		return er.findByEventProvince(province);
	}
	
	/* Método que regrese una lista de Event de otras provincias */
	public List<Event> getEventsNotNear(String province){
		return er.findByEventProvinceIsNot(province);
	}
	
}
