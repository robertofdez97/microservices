package com.microservices.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.common.clients.ProductsClient;
import com.microservices.common.models.Item;
import com.microservices.common.models.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@RestController
public class ItemController {

	@Autowired
	private Environment env;
	
//	@Value(value = "${text.configuration}")
//	private String text;
	
	@Autowired
	ProductsClient productsClient;

	@GetMapping("/findAll")
	public List<Item> findAll() {
		return productsClient.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@HystrixCommand(fallbackMethod = "alternativeMethod")
	@GetMapping("/findById")
	public Item ItemfindById(@RequestParam Long id, @RequestParam Integer quantity) {
		Product product = productsClient.findById(id);
		Item item = new Item(product,quantity);
		return item;
	}
	
	public Item alternativeMethod(@RequestParam Long id, @RequestParam Integer quantity) {
		Item item = new Item(Product.builder().name("alternative").build(),quantity);
		return item;
	}

	@GetMapping("/getConfig")
	public ResponseEntity<?> getConfig(@Value("${server.port}") String port){
		Map<String,String> ret = new HashMap<>();
		ret.put("port", port);
		if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			ret.put("emai.autor", env.getProperty("email.configuration"));
		}
		return new ResponseEntity<Map<String,String>>(ret, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return productsClient.create(product);
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
		Product oldProduct = productsClient.findById(id);
		if (oldProduct != null) {
			product.setId(id);
			return productsClient.create(product);
		}
		return null;

	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@RequestParam Long id ) {
		productsClient.deleteById(id); 
	}

}
