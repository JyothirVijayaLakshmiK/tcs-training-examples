package com.tcs.exceptions;

@SuppressWarnings("serial")
public class ProfileOrContactNotFoundException extends Exception {
	public ProfileOrContactNotFoundException(String error) {
		super(error);
	}
}