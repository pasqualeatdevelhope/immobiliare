package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import it.pasqualecavallo.studentsmaterial.authorization_framework.config.DefinitelyBasicAuthorizationFrameworkAutoconfiguration;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ExclusionPatterEvaluator;

@Configuration
@Import(DefinitelyBasicAuthorizationFrameworkAutoconfiguration.class)
public class AuthorizationConfiguration {

	@Bean
	ExclusionPatterEvaluator exclusionPatterEvaluator() {
		return new ExclusionPatterEvaluator().mustExcludeAntPathMatchers("/v3", "/v3/**", "/swagger-ui", "/swagger-ui/**");
	}
	
}
