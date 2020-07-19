package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@Component
public class HelloController {
	@Autowired
	DestinationsService service;
	
	@Autowired
	private DestinationsRepository destinationsRepository;
	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/destination")
	List<Destination> all() throws IOException {
	    return service.getDestinations();
	  }
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/destinationByID/{i}")
	List<Destination> byId(@PathVariable int i ) throws IOException {
	    return service.getDestinationByID(i);
	  }
	
	@PostMapping(path="/addDestination/{id}/{city}/{state}/{country}")
	public @ResponseBody String addNewDestination (@PathVariable String id, @PathVariable String city, @PathVariable String state,
			@PathVariable String country)
	{
		Destination dest = new Destination();
		
		dest.setId(id);
		dest.setCity(city);
		dest.setState(state);
		dest.setCountry(country);
		
		destinationsRepository.save(dest);

		
		return "Saved";
		
	}
/*	
	@PostMapping(path="/addDestination2/{id}/{city}/{state}/{country}")
	public @ResponseBody Destination addNewDestinationByClass (@PathVariable String id, @PathVariable String city, @PathVariable String state,
			@PathVariable String country)
	{
		Destination dest = new Destination();
		
		dest.setId(id);
		dest.setCity(city);
		dest.setState(state);
		dest.setCountry(country);
		
	//	destinationsRepository.save(dest);
		
		destinationsRepository.save(dest.getId(),dest.getCity(),dest.getState(),dest.getCountry());
		
		
		return dest;
		
	}
	*/
	
	
}
