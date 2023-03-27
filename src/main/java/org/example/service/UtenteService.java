package org.example.service;

import java.time.LocalDate;
import java.util.Optional;

import org.example.controllers.dto.ActivateRequestDto;
import org.example.controllers.dto.ActivateResponseDto;
import org.example.controllers.dto.RegistrationRequestDto;
import org.example.controllers.dto.RegistrationResponseDto;
import org.example.controllers.dto.StatusResponse;
import org.example.controllers.dto.StatusResponse.Status;
import org.example.entity.PromotionRequest;
import org.example.entity.Utente;
import org.example.exception.InvalidActivationCodeException;
import org.example.exception.UserNotFoundException;
import org.example.repository.PromotionRequestRepository;
import org.example.repository.RuoloRepository;
import org.example.repository.UtenteRepository;
import org.example.support.MainSender;
import org.example.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private MainSender mailSender;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RuoloRepository ruoloRepository;
	
	@Autowired
	private PromotionRequestRepository promotionRequestRepository;
	
	public RegistrationResponseDto register(RegistrationRequestDto request) {
		Optional<Utente> userByEmail = utenteRepository.findByEmail(request.getEmail());
		if(userByEmail.isPresent()) {
			throw new UserNotFoundException();
		} else {
			Utente utente = utenteRepository.save(utenteRequestToEntity(request));
			mailSender.sendEmail(utente);
			return utenteEntityToResponse(utente);
		}
	}

	public ActivateResponseDto activate(ActivateRequestDto request) {
		Optional<Utente> oUtente = utenteRepository.findByEmail(request.getEmail());
		if(oUtente.isPresent()) {
			Utente u = oUtente.get();
			if(u.getActivationCode().equals(request.getActivationCode())) {
				u.setActivationCode(null);
				u.setActive(true);
				utenteRepository.save(u);
				ActivateResponseDto response = new ActivateResponseDto();
				response.setStatus(Status.OK);
				response.setUsername(u.getUsername());
				return response;
			} else {
				throw new InvalidActivationCodeException();
			}
		} else {
			throw new UserNotFoundException();
		}
	}
	
	public StatusResponse promoteMe(String username) {
		PromotionRequest promotionRequest = new PromotionRequest();
		promotionRequest.setLocalDate(LocalDate.now());
		promotionRequest.setUsername(username);
		promotionRequest.setUtente(utenteRepository.findById(username).get());
		promotionRequestRepository.save(promotionRequest);
		return new StatusResponse();
	}




	private Utente utenteRequestToEntity(RegistrationRequestDto request) {
    	Utente utente = new Utente();
    	utente.setEmail(request.getEmail());
    	utente.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    	utente.setUsername(request.getUsername());
    	utente.setActivationCode(StringUtils.getRandomString(6));
    	utente.setRuolo(ruoloRepository.findByNomeRuolo("ROLE_UTENTE"));
    	return utente;
    }

    private RegistrationResponseDto utenteEntityToResponse(Utente utente){
    	RegistrationResponseDto response = new RegistrationResponseDto();
    	response.setStatus(Status.OK);
    	return response;
    }

	}
