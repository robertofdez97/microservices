package com.microservices.products.exceptions;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5199102901296301201L;
	private HttpStatus status;
	private String error;
	private List<String> erros;
}
