package com.microservices.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.models.Item;
import com.microservices.models.feigns.IItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier(value = "itemServiceFeign")
	IItemService itemService;
	
	@GetMapping("/findAll")
	public List<Item> findAll() {
		return itemService.findAll();
	}
	
	@GetMapping("/findById")
	public Item findById(@RequestParam Long productId, @RequestParam Integer quentity) {
		return itemService.findById(productId,quentity);
	}
	
	
}
