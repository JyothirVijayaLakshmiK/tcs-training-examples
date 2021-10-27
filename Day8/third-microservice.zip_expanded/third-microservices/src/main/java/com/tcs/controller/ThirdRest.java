package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("third-api")
public class ThirdRest {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public String hello() {
		String msg = restTemplate.getForObject("http://HELLO-FIRST-MS/first-api", String.class);
		return "Third Microservice got: "+msg;
	}
	@GetMapping("stmts")
	public ResponseEntity<Object> fetchStatements() {
		Transaction tx = restTemplate.getForObject("http://HELLO-FIRST-MS/first-api/statements", Transaction.class);
		Wallet wallet = new Wallet();
		wallet.setWalletNumber(tx.getAccountNumber());
		wallet.setAmount(wallet.getAmount() + tx.getAmount());
		return ResponseEntity.status(200).body(wallet);
	}
}
