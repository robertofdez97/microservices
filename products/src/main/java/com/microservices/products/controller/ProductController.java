package com.microservices.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.models.Product;
import com.microservices.products.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/findAll")
	public List<Product> findAll(){
		return (List<Product>) productService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Product findById(@PathVariable Long id) throws Exception{
		return productService.findById(id).orElseThrow(() -> new Exception("Product not found"));
	}
	
}
