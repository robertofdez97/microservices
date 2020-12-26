package com.microservices.models.feigns;

import java.util.List;

import com.microservices.models.Item;

public interface IItemService {
	public List<Item> findAll();
	public Item findById(Long id,Integer quantity);
}
