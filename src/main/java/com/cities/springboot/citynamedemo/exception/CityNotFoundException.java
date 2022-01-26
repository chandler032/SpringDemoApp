package com.cities.springboot.citynamedemo.exception;

public class CityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CityNotFoundException(String message) {
		super(message);
	}

	public CityNotFoundException(Throwable cause) {
		super(cause);
	}
}
