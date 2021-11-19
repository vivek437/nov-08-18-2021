package com.intuit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//SERVICE B
@RestController
public class WeatherController {

	
	@GetMapping("weather/{city}")
	public String getTemperature(@PathVariable String city) {
		return "Temperature of " + city + " is " + (Math.random() * 50);
	}
}
