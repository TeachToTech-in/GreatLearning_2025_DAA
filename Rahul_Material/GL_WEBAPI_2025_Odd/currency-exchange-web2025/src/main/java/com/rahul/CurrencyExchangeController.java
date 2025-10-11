package com.rahul;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyRepository repository;
	//http://localhost:8000/currency-exchange/from/USD/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue
	(@PathVariable String from ,@PathVariable String to) {
		CurrencyExchange currencyexchange = repository.findByFromAndTo(from, to);
				if(currencyexchange==null) {
					throw new NullPointerException("The Required Conversion rate is not "
							+ "available "+ from +"----"+to);
				}
		String port = environment.getProperty("local.server.port");
		currencyexchange.setEnvironment(port);
		return currencyexchange;
	}
	
}
