package com.microservices.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.common.models.Product;
import com.microservices.products.exceptions.ProductExcption;
import com.microservices.products.repository.ProductsRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductsRepository productRepository;
	
	
	@Override
	public List<Product> findAll() {
		List<Product> list = (List<Product>) productRepository.findAll();
		if(list.isEmpty()) throw new RuntimeException("Users nos found runtime");
		return list;
	}

	@Override
	public Optional<Product> findById(Long id) {
		Optional<Product> products = productRepository.findById(id);
		Product product = products.orElseThrow(() -> new ProductExcption("product not found"));
		return Optional.of(product);
	}

}
