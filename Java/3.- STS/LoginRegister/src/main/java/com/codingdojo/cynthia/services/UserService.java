package com.codingdojo.cynthia.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.cynthia.models.User;
import com.codingdojo.cynthia.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
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
	
}
