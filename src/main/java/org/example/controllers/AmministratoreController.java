package org.example.controllers;

import java.util.List;

import org.example.controllers.dto.ApprovePromotionRequestDto;
import org.example.controllers.dto.PromotionResponseDto;
import org.example.controllers.dto.StatusResponse;
import org.example.service.AmministratoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;

@RestController
@RequestMapping("/admin")
public class AmministratoreController {

	@Autowired
	private AmministratoreService amministratoreService;
	
	@GetMapping("/promotion_requests")
	@RoleSecurity("ROLE_AMMINISTRATORE")
	public List<PromotionResponseDto> getAllPromotionRequests() {
		return amministratoreService.getAllPromotionRequests();
	}
	
	@PostMapping("/approve-promotion")
	@RoleSecurity("ROLE_AMMINISTRATORE")
	public StatusResponse approvePromotion(@RequestBody ApprovePromotionRequestDto request) {
		return amministratoreService.approvePromotion(request.getUsername());
	}
}
