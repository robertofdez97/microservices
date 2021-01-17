package com.microservices.products.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductExcption.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiError productExceptionHandler(ProductExcption exception, HttpServletRequest request) {
		ApiError apiError = ApiError.builder().error(exception.getError()).status(HttpStatus.NO_CONTENT).build();
		return apiError;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ApiError runtimeExceptionHandler(RuntimeException exception, WebRequest request) {
		ApiError apiError = ApiError.builder().error(exception.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return apiError;
	}

}
