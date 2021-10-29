package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tcs.service.SecondServiceImpl;

@RestController
@RequestMapping("second-api")
public class SecondRest {
	// RestTemplate object is avaialable in the spring container
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private Client fiegn; // this internally uses RestTemplate & LoadBalancer 
	
	@Autowired
	private SecondServiceImpl service;
	
	@GetMapping
	public String hello() {
		// calling first microservice using the logical name
		//String msg = restTemplate.getForObject("http://HELLO-FIRST-MS/first-api", String.class);
		//String msg = fiegn.callingHello(); // sends request to http://HELLO-FIRST-MS/first-api
		//return "Second Microservice got: "+msg;
		return service.getMessageFromRemote();
	}
	@GetMapping("stmts")
	public ResponseEntity<Object> fetchStatements() {
		// calling first microservice statements using the logical name
//		Transaction tx = restTemplate.getForObject("http://HELLO-FIRST-MS/first-api/statements", 
//				Transaction.class);
		Transaction tx = fiegn.callingFetchStatements(); // http://HELLO-FIRST-MS/first-api/statements
		// Since JSON structure has the properties matching to Transaction class we need this model
		// Note: Class name can be anything, but their properties must match to JSON properties
		Wallet wallet = new Wallet();
		// assuming wallet number is same as account number
		wallet.setWalletNumber(tx.getAccountNumber());
		// initialize the wallet balance with the amount you recieve
		wallet.setAmount(wallet.getAmount() + tx.getAmount());
		return ResponseEntity.status(200).body(wallet);
	}
}
