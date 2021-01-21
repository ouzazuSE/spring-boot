package com.clown.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@org.springframework.stereotype.Repository

public class CartRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Cart> findAll(){
		javax.persistence.Query q = em.createQuery("from Cart");
		return q.getResultList();
	}
	
	public Cart getCart(Integer id) {
		return em.find(Cart.class, id);
	}
}
