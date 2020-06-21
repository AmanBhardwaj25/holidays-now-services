package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Component
public class HelloController {
	@Autowired
	DestinationsService service;
	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/destination")
	List<Destination> all() {
	    return service.getDestinations();
	  }
	
	
	
}
