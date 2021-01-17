package com.microservices.products.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductExcption extends RuntimeException{

	private static final long serialVersionUID = 4418366769056842928L;
	
	private String error;
	
}
