package com.clown.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",allowedHeaders = "*")

@RestController	
public class PersonController {
	
	@GetMapping("/bmi")
	public Person bmi(@ModelAttribute Person clown) {
		Double bmi = (clown.getWeight()/((clown.getHeight()/100)*(clown.getHeight()/100)));
		clown.setBmi(bmi);
		return clown; 
	}
}
