package com.clown.shop.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	private Date cartCreateDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="cart")
	private List<Product> product;

	@JsonManagedReference
	public List<Product> getProduct(){
		return product;
	}
	
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Date getCartCreateDate() {
		return cartCreateDate;
	}

	public void setCartCreateDate(Date cartCreateDate) {
		this.cartCreateDate = cartCreateDate;
	}
	
}
