package com.microservices.common.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.common.models.Product;

@FeignClient(name = "productsMicroservice")
public interface ProductsClient {

	@GetMapping("/findAll")
	public List<Product> findAll();

	@GetMapping("/findById")
	public Product findById(@RequestParam Long id);
	
	@PostMapping("/create")
	public Product create(@RequestBody Product product);
	
	@PutMapping("/update/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id);
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id );
}
