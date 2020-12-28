package com.microservices.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.common.models.Product;
import com.microservices.products.repositories.ProductRepository;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	ProductRepository repository;
	
	@Override
	public List<Product> findAll() {
		return (List<Product>) repository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
}
