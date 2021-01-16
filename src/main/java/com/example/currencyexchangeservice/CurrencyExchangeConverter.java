package com.example.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeConverter 
{

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repos;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchange(@PathVariable String from,@PathVariable String to)
	{
		//=new ExchangeValue(100l,from,to,BigDecimal.valueOf(65));
		ExchangeValue ev=new ExchangeValue();
		 ev=repos.findByFromAndTo(from, to);
		 System.out.println("exchange values"+ev);
		 System.out.println(from+",,,,"+to);
		ev.setPort(Integer.parseInt(environment.getProperty("local.server.port")));	
		return ev;
	}
} 
