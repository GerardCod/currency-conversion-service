package com.ibm.aac.gerardo.currency.conversion.service.controllers;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.aac.gerardo.currency.conversion.service.dtos.CurrencyConversion;
import com.ibm.aac.gerardo.currency.conversion.service.services.CurrencyExchangeProxy;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(
		@PathVariable String from,
		@PathVariable String to,
		@PathVariable BigDecimal quantity
	) {
		
		CurrencyConversion currency = proxy.retrieveExchange(from, to);
		return new CurrencyConversion(
				currency.getId(),
				from, to,
				currency.getConversionMultiple(), quantity, 
				quantity.multiply(currency.getConversionMultiple()),
				currency.getEnvironment() + " feign");
	}
	
}
