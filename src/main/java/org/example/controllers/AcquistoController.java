package org.example.controllers;

import org.example.controllers.dto.CreateAcquistoRequest;
import org.example.controllers.dto.CreateAcquistoResponse;
import org.example.controllers.dto.GetAcquistoListResponse;
import org.example.service.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;

@Service
@RequestMapping("/acquisto")
public class AcquistoController {

	@Autowired
	private AcquistoService acquistoService;
	
	@GetMapping
	//ignorare le annotations sulla security, non fanno parte del checkpoint
	@RoleSecurity(value = "ROLE_UTENTE")
	public CreateAcquistoResponse createAcquisto(CreateAcquistoRequest createAcquistoRequest) {
		String username = AuthenticationContext.get().getUsername();
		return acquistoService.acquista(createAcquistoRequest, username);
	}
	
	@GetMapping
	//ignorare le annotations sulla security, non fanno parte del checkpoint
	@RoleSecurity(value = "ROLE_UTENTE")
	public GetAcquistoListResponse getAcquisti(@RequestParam Integer page, Integer pageSize) {
		String username = AuthenticationContext.get().getUsername();
		return acquistoService.getPage(page, pageSize, username);
	}
	
}
