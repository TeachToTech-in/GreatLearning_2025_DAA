package com.rahul;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeProxy proxy;

//http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion cc = responseEntity.getBody();
		cc.setQuantity(quantity);
		cc.setTotalCalculatedAmount(quantity.multiply(cc.getConversionMultiple()));
		return cc;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateConversion_feign(
			@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {

		
		CurrencyConversion cc = proxy.retrieveExchangeValue(from, to);
		cc.setQuantity(quantity);
		cc.setTotalCalculatedAmount(quantity.multiply(cc.getConversionMultiple()));
		cc.setEnvironment(cc.getEnvironment()+"feign");
		return cc;
	}


}
