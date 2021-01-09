package com.microservices.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.commonsUsers.models.User;

@FeignClient(name = "usersMicroservice")
public interface UserClient {

	@GetMapping("/user/search/username")
	public User findByUsername(@RequestParam String username);
	
}
