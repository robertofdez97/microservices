package com.microservices.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.common.models.Product;
import com.microservices.products.repository.ProductsRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductsRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

}
