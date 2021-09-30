package com.ibm.aac.gerardo.currency.conversion.service.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.aac.gerardo.currency.conversion.service.dtos.CurrencyConversion;

@FeignClient(name = "exchange-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchange(
		@PathVariable String from,
		@PathVariable String to
	);
	
}
