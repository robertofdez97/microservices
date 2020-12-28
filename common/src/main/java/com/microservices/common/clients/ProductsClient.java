package com.microservices.common.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.common.models.Product;

@FeignClient(name = "productsMicroservice")
public interface ProductsClient {

	@GetMapping("/findAll")
	public List<Product> findAll();

	@GetMapping("/findById")
	public Product findById(@RequestParam Long id);
}
