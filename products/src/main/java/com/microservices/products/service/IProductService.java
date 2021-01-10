package com.microservices.products.service;

import java.util.List;
import java.util.Optional;

import com.microservices.common.models.Product;

public interface IProductService {
	
	public List<Product> findAll();
	
	public Optional<Product> findById(Long id); 
	
	
}
