package com.microservices.items.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.microservices.items.clients.IProductClientRest;
import com.microservices.models.Item;

@Service(value = "itemServiceFeign")
public class ItemServiceFeign implements IItemService{

	@Autowired
	private IProductClientRest clientFeign;
	
	@Override
	public List<Item> findAll() {
		return clientFeign.findAll().stream().map(product -> new Item(product,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(clientFeign.findById(id), quantity);
	}

}
