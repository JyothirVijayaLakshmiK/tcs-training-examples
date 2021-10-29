package com.tcs.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// this interface acts like the reusable client to call the first microservice end points
@FeignClient("http://HELLO-FIRST-MS/first-api")
public interface Client {
	
	@GetMapping
	public String callingHello(); // if you call this method then it sends request to first-api & returns string data
	
	@GetMapping("statements")
	public Transaction callingFetchStatements(); // if you call this method then it sends request to first-api/statements
}
