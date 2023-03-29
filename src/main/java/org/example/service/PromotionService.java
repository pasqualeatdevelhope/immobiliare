package org.example.service;

import org.example.controllers.dto.BaseResponse;
import org.example.controllers.dto.PromotionRequestResponseDTO;
import org.example.entity.PromotionRequest;
import org.example.entity.Utente;
import org.example.exception.RequestAlreadyPresentException;
import org.example.exception.UserNotFoundException;
import org.example.repository.PromotionRepository;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public BaseResponse createRequest(String username) {
        Optional<Utente> utente = utenteRepository.findById(username);
        if (utente.isPresent()) {
            if (!promotionRepository.findByUtente(utente.get()).isPresent()) {
                PromotionRequest promotionRequest = new PromotionRequest();
                promotionRequest.setUtente(utente.get());
                promotionRepository.save(promotionRequest);
                return BaseResponse.ok();
            } else {
                throw new RequestAlreadyPresentException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }
    public List<PromotionRequestResponseDTO> getAllPromotionRequests(){
        List<PromotionRequest> promotionRequestList = promotionRepository.findAll();
        return promotionRequestEntitiesToDTO(promotionRequestList);
    }

    public List<PromotionRequestResponseDTO> promotionRequestEntitiesToDTO(List<PromotionRequest> promotionRequests ){
        List<PromotionRequestResponseDTO> responseDTOS = new ArrayList<>();
        for (PromotionRequest promotionRequest: promotionRequests) {
            responseDTOS.add(promotionRequestEntityToDTO(promotionRequest));
        }
        return responseDTOS;
    }

    private PromotionRequestResponseDTO promotionRequestEntityToDTO(PromotionRequest promotionRequest) {
        PromotionRequestResponseDTO promotionRequestResponseDTO = new PromotionRequestResponseDTO();
        promotionRequestResponseDTO.setUsername(promotionRequest.getUtente().getUsername());
        promotionRequestResponseDTO.setEmail(promotionRequest.getUtente().getEmail());
        promotionRequestResponseDTO.setRequestDate(promotionRequest.getDataRichiesta());
        return promotionRequestResponseDTO;
    }
}
