package com.tcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.beans.Transaction;

@RestController
@RequestMapping("first-api")
public class FirstRest {
	
	@GetMapping
	public String hello() {
		return "Welcome to First Microservice";
	}
	@GetMapping("statements")
	public Transaction fetchStatements() {
		// all the properties are hard-coded to make it simple
		Transaction tx = new Transaction(9911252355L, 4400004L, 5000);
		System.out.println("fetchStatements() inside the first microservice");
		return tx;
	}
}
