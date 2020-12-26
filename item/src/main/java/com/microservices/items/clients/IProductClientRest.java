package com.microservices.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.models.Product;

@FeignClient(name = "productsService", url = "localhost:8001")
public interface IProductClientRest {
	
	@GetMapping("/findAll")
	public List<Product> findAll();
	
	@GetMapping("/findById/{id}")
	public Product findById(@PathVariable Long id);
}
