package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.controller.Client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

// this calls another microservice
@Service
public class SecondServiceImpl {

	@Autowired
	private Client feign;
	
	@Autowired
	private RestTemplate template;
	
	@CircuitBreaker(name = "getMessage", fallbackMethod = "getAlternateMessage")
	public String getMessageFromRemote() {
		System.out.println("----- Making Request to Remote Service ------------");
		//String message = feign.callingHello(); // chances of cascading failures
		String message = template.getForObject("http://HELLO-FIRST-MS/first-api", String.class);
		return message;
	}
	// fallback method is the alternate method for remote service
	public String getAlternateMessage(Throwable t) {
		System.err.println("-------- fallback method is executed --------"+t.toString());
		
		return "Sorry this is an alternate message";
	}
}
