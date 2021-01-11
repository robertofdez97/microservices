package com.microservices.products.controller;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.common.models.Product;
import com.microservices.products.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	IProductService productService;

	@GetMapping(path = "/findAll")
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	@GetMapping(path = "/findById")
	public Product findById(@RequestParam Long id) {
		return productService.findById(id).get();
	}

	@PostMapping("/create")
	public Product create(@RequestBody Product product) {
		throw new NotImplementedException();
	}

	@PutMapping("/update/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		throw new NotImplementedException();
	}

	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		throw new NotImplementedException();

	}

}
