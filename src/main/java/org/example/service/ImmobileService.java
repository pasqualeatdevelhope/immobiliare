package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.controllers.dto.ImmobileRequestDto;
import org.example.controllers.dto.ImmobileResponseDto;
import org.example.entity.Immobile;
import org.example.repository.ImmobileRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ImmobileService implements InitializingBean {

    @Autowired
    private ImmobileRepository immobileRepository;


	@Override
	public void afterPropertiesSet() throws Exception {
		immobileRepository.save(null);
	}

    
    public ImmobileResponseDto postImmobile(ImmobileRequestDto request) {
        return immobileEntityToResponse(immobileRepository.save(immobileRequestToEntity(request)));
    }

    public ImmobileResponseDto getImmobile(Long id) {
        Immobile immobile = immobileRepository.findById(id).orElseThrow(RuntimeException::new);
        return immobileEntityToResponse(immobile);
    }

    public ImmobileResponseDto putImmobile(Long id, ImmobileRequestDto request) {
        Immobile immobile = immobileRepository.findById(id).orElseThrow(RuntimeException::new);
        immobileRequestToEntity(request, immobile);
        return immobileEntityToResponse(immobileRepository.save(immobile));

    }
    public ImmobileResponseDto delete(Long id) {
        Immobile immobile = immobileRepository.findById(id).orElseThrow(RuntimeException::new);
        immobileRepository.delete(immobile);
        return immobileEntityToResponse(immobile);
    }

    public List<ImmobileResponseDto> getImmobilePage(Integer page, Integer pageSize) {
        Page<Immobile> immobili = immobileRepository.findAll(PageRequest.of(page, pageSize));
        return immobileEntitiesToResponses(immobili.getContent());
    }

    private List<ImmobileResponseDto> immobileEntitiesToResponses(List<Immobile> immobili) {
        List<ImmobileResponseDto> response = new ArrayList<>();
        for(Immobile immobile : immobili) {
            response.add(immobileEntityToResponse(immobile));
        }
        return response;
    }

    private Immobile immobileRequestToEntity(ImmobileRequestDto request) {
        Immobile immobile = new Immobile();
        return immobileRequestToEntity(request, immobile);
    }
    
    private Immobile immobileRequestToEntity(ImmobileRequestDto request, Immobile immobile){
        immobile.setAddress(request.getAddress());
        immobile.setMq(request.getMq());
        immobile.setPiani(request.getPiani());
        immobile.setPrezzo(request.getPrezzo());
        immobile.setVenditore("Venditore Mock");
        return immobile;
    }

    private ImmobileResponseDto immobileEntityToResponse(Immobile immobile){
        ImmobileResponseDto response = new ImmobileResponseDto();
        response.setAddress(immobile.getAddress());
        response.setId(immobile.getId());
        response.setMq(immobile.getMq());
        response.setPiani(immobile.getPiani());
        response.setPrezzo(immobile.getPrezzo());
        response.setVenditore(immobile.getVenditore());
        return response;
    }
}
