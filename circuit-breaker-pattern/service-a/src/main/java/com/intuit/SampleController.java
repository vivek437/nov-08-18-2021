package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//SERVICE A
@RestController
public class SampleController {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
	@GetMapping("/report/{city}")
	public String getCityReport(@PathVariable String city) {
		return cbFactory.create("cityCircuit").run(
				() -> {
					System.out.println("****Trying normal output");
					return getFromServer(city);
				}, 
				(t) -> {
					System.out.println("----Calling fallback method");
					return getFromServerFallback(city);
				});
	}

	private String getFromServer(String city) {
		String url = "http://localhost:8082/weather/" + city;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.getBody();
	}
	
	private String getFromServerFallback(String city) {
		return "Oops! Service is down. Here's the temperature of " + city + " from cache " + Math.random() * 50;
	}
	
}
