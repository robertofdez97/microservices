package com.microservices.products.services;

import java.util.List;

import com.microservices.common.models.Product;

public interface IProductService {
	public List<Product> findAll();

	public Product findById(Long id);

	public Product save(Product product);

	public void deleteById(Long id);

}
