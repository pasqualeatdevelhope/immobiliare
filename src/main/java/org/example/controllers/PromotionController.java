package org.example.controllers;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ZeroSecurity;
import org.example.controllers.dto.BaseResponse;
import org.example.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping("/")
    @ZeroSecurity
    private BaseResponse createRequest(){
        return promotionService.createRequest(AuthenticationContext.get().getUsername());
    }
}
