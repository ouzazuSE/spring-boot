package com.clown.shop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",allowedHeaders = "*")

@RestController
@RequestMapping("/api/v1")
public class cartAPI {
	@Autowired
	CartRepository repo;
	
	@GetMapping("/carts")
	public List<Cart> getCarts(){
		return repo.findAll();
	}
	
	@GetMapping("/cart/{id}")
	public Cart getOneCart(@PathVariable("id") Integer id) {
		return repo.getCart(id);
	}
}
