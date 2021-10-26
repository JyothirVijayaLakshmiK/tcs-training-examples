package com.tcs.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String error) {
		super(error);
	}
}