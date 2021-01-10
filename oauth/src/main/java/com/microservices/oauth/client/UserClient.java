package com.microservices.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.commonsUsers.models.User;

@FeignClient(name = "usersMicroservice")
public interface UserClient {

	@GetMapping("/user/search/username")
	public User findByUsername(@RequestParam String username);
	
	@PutMapping("/user/{id}")
	public User update(@RequestBody User user, @PathVariable Long id);
	
}
