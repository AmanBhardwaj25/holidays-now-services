package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Component
public class HelloController {

	@RequestMapping("/Destinations")
	public destinations destinations(String places){
		return new destinations(places);
	}
}
