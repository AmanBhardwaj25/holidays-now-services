package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

import javax.websocket.server.PathParam;

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
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/destinationByID/{i}")
	List<Destination> byId(@PathVariable int i ) throws FileNotFoundException {
	    return service.getDestinationByID(i);
	  }
	
	
	
}
