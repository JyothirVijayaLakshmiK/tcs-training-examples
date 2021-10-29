package com.tcs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client-config")
public class ConfigRest {
	
	@Value("${envirnoment.message}")
	private String environmentMessage;
	
	@GetMapping
	public String readMessage() {
		return environmentMessage;
	}
}

