package org.example.support;

import org.example.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MainSender {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String mailSender;
	
	public void sendEmail(Utente utente) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(mailSender);
		mailMessage.setReplyTo(mailSender);
		mailMessage.setSubject("Registration completed");
		mailMessage.setText("Ciao " + utente.getUsername() + ", attiva la tua mail col codice " + utente.getActivationCode());
		mailMessage.setTo(utente.getEmail());
		javaMailSender.send(mailMessage);
	}
	
}
