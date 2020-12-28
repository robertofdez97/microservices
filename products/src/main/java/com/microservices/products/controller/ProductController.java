package com.microservices.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.common.models.Product;
import com.microservices.products.services.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/findAll")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/findById")
	public Product findById(@RequestParam Long id){
		Product product = productService.findById(id);
		product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return product;
	}
	
	
}
