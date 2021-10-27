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
		return "First Microservice";
	}
	@GetMapping("statements")
	public Transaction fetchStatements() {
		Transaction tx = new Transaction(78412555L, 870002L, 4000);
		System.out.println("fetchStatements() inside the first microservice");
		return tx;
	}
}
