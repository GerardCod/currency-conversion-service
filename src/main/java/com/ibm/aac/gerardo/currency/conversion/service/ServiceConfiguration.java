package com.ibm.aac.gerardo.currency.conversion.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfiguration {
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
}
