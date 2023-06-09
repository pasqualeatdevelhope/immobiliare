package org.example.controllers;

import java.util.List;

import org.example.controllers.dto.ImmobileRequestDto;
import org.example.controllers.dto.ImmobileResponseDto;
import org.example.service.ImmobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext.Principal;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ZeroSecurity;

@RestController
@RequestMapping("/immobile")
public class ImmobileController {

    @Autowired
    private ImmobileService immobileService;

    @PostMapping
    @RoleSecurity("ROLE_AGENZIA")
    public ImmobileResponseDto postImmobile(@RequestBody ImmobileRequestDto request) {
        return immobileService.postImmobile(request);
    }

    @GetMapping("/{id}")
    @ZeroSecurity
    public ImmobileResponseDto getImmobile(@PathVariable("id") Long id) {
        return immobileService.getImmobile(id);
    }



    @GetMapping("/page")
    @ZeroSecurity
    public List<ImmobileResponseDto> getImmobilePage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return immobileService.getImmobilePage(page, pageSize);

    }

    @PutMapping("/{id}")
    @RoleSecurity("ROLE_AGENZIA")
    public ImmobileResponseDto putImmobile(@PathVariable("id") Long id,
                                           @RequestBody ImmobileRequestDto request)  {
        return immobileService.putImmobile(id,request);
    }


    @DeleteMapping("/{id}")
    @RoleSecurity(value = {"ROLE_AGENZIA", "ROLE_AMMINISTRATORE"})
    public ImmobileResponseDto delete(@PathVariable("id") Long id) {
        return immobileService.delete(id);
    }



}
