package org.example.dao;

import java.util.Arrays;
import java.util.Optional;

import org.example.entity.Utente;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private UtenteRepository utenteRepository;
	
	@Override
	public UserDetails getUserByUsername(String username) {
		Optional<Utente> oUtente = utenteRepository.findById(username);
		if(oUtente.isPresent()) {
			Utente u = oUtente.get();
			UserDetails userDetails = new UserDetails();
			userDetails.setPassword(u.getPassword());
			userDetails.setUsername(u.getUsername());
			userDetails.setRoles(Arrays.asList("ROLE_USER"));
			return userDetails;
		} else {
			return null;
		}
	}

}
