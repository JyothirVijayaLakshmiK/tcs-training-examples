package com.tcs.exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String message) {
		super(message);
	}	
}
