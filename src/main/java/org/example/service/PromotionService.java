package org.example.service;

import org.example.controllers.dto.BaseResponse;
import org.example.entity.PromotionRequest;
import org.example.entity.Utente;
import org.example.exception.RequestAlreadyPresentException;
import org.example.exception.UserNotFoundException;
import org.example.repository.PromotionRepository;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
