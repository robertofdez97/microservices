package com.microservices.products.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.common.models.Product;
import com.microservices.products.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository repository;

	@Override
	@Transactional
	public List<Product> findAll() {
		return (List<Product>) repository.findAll();
	}

	@Override
	@Transactional
	public Product findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		return repository.save(product);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
