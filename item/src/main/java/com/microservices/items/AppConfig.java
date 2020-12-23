package com.microservices.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean(value = "restClient")
	public RestTemplate registrationRestTemplate(){
		return new RestTemplate();
	}
}
