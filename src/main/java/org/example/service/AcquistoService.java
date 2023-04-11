package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.controllers.dto.CreateAcquistoRequest;
import org.example.controllers.dto.CreateAcquistoResponse;
import org.example.controllers.dto.GetAcquistoListResponse;
import org.example.controllers.dto.GetAcquistoListResponse.GetAcquistoResponse;
import org.example.entity.Acquisto;
import org.example.exception.UserNotFoundException;
import org.example.repository.AcquistoRepository;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AcquistoService {

	@Autowired
	private AcquistoRepository acquistoRepository;
	
	@Autowired
	private UtenteRepository repository;
	
	public GetAcquistoListResponse getPage(Integer page, Integer pageSize, String username) {
		Acquisto acquisto = new Acquisto();
		acquisto.setUtente(repository.findById(username).orElseThrow(() -> new UserNotFoundException()));
		Page<Acquisto> acquisti = acquistoRepository.findAll(Example.of(acquisto), PageRequest.of(page, pageSize));
		GetAcquistoListResponse response = new GetAcquistoListResponse();
		List<GetAcquistoResponse> list = new ArrayList<>();
		for(Acquisto a : acquisti) {
			GetAcquistoResponse item = new GetAcquistoResponse();
			item.setAddress(a.getImmobile().getAddress());
			item.setDate(a.getDate());
			item.setMq(a.getImmobile().getMq());
			item.setPiani(a.getImmobile().getPiani());
			item.setPrezzo(a.getImmobile().getPrezzo());
			item.setVenditore(a.getImmobile().getVenditore());
			list.add(item);
		}
		response.setResponse(list);
		return response;
	}

	//il metodo solleva un'eccezione di tipo org.example.exception.InvalidImmobileIdException 
	// se l'immobile che si sta cercando di acquistare non esiste
	public CreateAcquistoResponse acquista(CreateAcquistoRequest createAcquistoRequest, String username) {

	}

	
	
	
}
