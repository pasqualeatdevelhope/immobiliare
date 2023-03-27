package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.controllers.dto.PromotionResponseDto;
import org.example.controllers.dto.StatusResponse;
import org.example.entity.PromotionRequest;
import org.example.entity.Ruolo;
import org.example.entity.Utente;
import org.example.repository.PromotionRequestRepository;
import org.example.repository.RuoloRepository;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmministratoreService {

	@Autowired
	private PromotionRequestRepository promotionRequestRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private RuoloRepository ruoloRepository;
	
	public List<PromotionResponseDto> getAllPromotionRequests() {
		List<PromotionRequest> requests = promotionRequestRepository.findAll();
		List<PromotionResponseDto> response = new ArrayList<>();
		for(PromotionRequest promotionRequest : requests) {
			PromotionResponseDto item = new PromotionResponseDto();
			item.setCurrentRole(promotionRequest.getUtente().getRuolo().getNomeRuolo());
			item.setEmail(promotionRequest.getUtente().getEmail());
			item.setUsername(promotionRequest.getUtente().getUsername());
			item.setLocalDate(promotionRequest.getLocalDate());
			response.add(item);
		}
		return response;
	}

	public StatusResponse approvePromotion(String username) {
		promotionRequestRepository.deleteById(username);
		Optional<Utente> oUtente = utenteRepository.findById(username);
		if(oUtente.isPresent()) {
			Utente u = oUtente.get();
			u.setRuolo(ruoloRepository.findByNomeRuolo("ROLE_AGENZIA"));
			utenteRepository.save(u);
		}
		return new StatusResponse();
	}

	
	
}
