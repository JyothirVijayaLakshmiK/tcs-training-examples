package com.tcs.exceptions;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {
		super();
	}
	public InsufficientBalanceException(String message) {
		super(message);
	}	
}
