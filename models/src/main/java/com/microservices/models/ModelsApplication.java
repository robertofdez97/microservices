package com.microservices.models;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ModelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelsApplication.class, args);
	}

}
