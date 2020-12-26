package com.microservices.items.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.models.Item;
import com.microservices.models.Product;

@Service(value = "itemServiceRestClient")
public class ItemServiceRestClient implements IItemService {

	@Autowired
	private RestTemplate restclient;

	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays
				.asList(restclient.getForObject("http://localhost:8001/findAll", Product[].class));
		List<Item> items = products.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
		return items;
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(id));
		Product product = restclient.getForObject("http://localhost:8001/findById/{id}", Product.class, params);
		return new Item(product, 2);
	}

}
