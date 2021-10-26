package com.tcs.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException(String error) {
		super(error);
	}
}