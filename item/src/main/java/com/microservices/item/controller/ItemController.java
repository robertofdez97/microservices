package com.microservices.item.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.common.clients.ProductsClient;
import com.microservices.common.models.Item;
import com.microservices.common.models.Product;

@RestController
public class ItemController {

	@Autowired
	ProductsClient productsClient;

	@GetMapping("/findAll")
	public List<Item> findAll() {
		return productsClient.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@GetMapping("/findById")
	public Item ItemfindById(@RequestParam Long id, @RequestParam Integer quantity) {
		Product product = productsClient.findById(id);
		Item item = new Item(product,quantity);
		return item;
	}

}
