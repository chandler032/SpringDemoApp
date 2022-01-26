package com.cities.springboot.citynamedemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CityErrorResponse> handleExceptions (CityNotFoundException ex){
		
		CityErrorResponse error = new CityErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<CityErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CityErrorResponse> handleExceptions (Exception ex){
		
		CityErrorResponse error = new CityErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CityErrorResponse>(error, HttpStatus.BAD_REQUEST);
		
	}
}
