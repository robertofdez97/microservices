package com.microservices.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.common.models.Product;
import com.microservices.products.services.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/findAll")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/findById")
	public Product findById(@RequestParam Long id){
		return productService.findById(id);
	}
	
	
}
