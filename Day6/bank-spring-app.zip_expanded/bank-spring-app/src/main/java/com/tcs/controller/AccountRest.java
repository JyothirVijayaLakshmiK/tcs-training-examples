package com.tcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.beans.CustomResponse;
import com.tcs.beans.Account;
import com.tcs.exceptions.*;
import com.tcs.service.AccountService;

@RestController
@RequestMapping("Account")
public class AccountRest {

	@Autowired
	private AccountService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveAcount(Account account) {
		ResponseEntity<Object> response = 
				ResponseEntity.status(HttpStatus.CREATED).body(service.register(account));
		return response;
	}
	@GetMapping(path = "{id}/{pwd}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findaccount(@PathVariable("id") int accountno,@PathVariable("pwd") String password) {
		ResponseEntity<Object> response = null;
		try {
			Account account = service.fetchAccountByIdandPassword(accountno,password);
			response = ResponseEntity.status(HttpStatus.OK).body(account);
		} catch(AccountNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}catch(PassowrdMismatchException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	@PutMapping(path = "{id}/{opwd}/{npwd}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updatePassword(@PathVariable("id") int id,@PathVariable("opwd") String oldpassword,@PathVariable("npwd") String newpassword) {
		ResponseEntity<Object> response = null;
		try {
			service.updatePassword(id, oldpassword,newpassword);
			CustomResponse data = new CustomResponse();
			data.setMsg(" Password Updated for account no "+id);
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		} catch(AccountNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}catch(PassowrdMismatchException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	@PutMapping(path = "{did}/{cid}/{pwd}/{amt}")
	public ResponseEntity<Object> transfer(@PathVariable("did") int did,@PathVariable("cid") int cid,@PathVariable("pwd") String dpwd,@PathVariable("amt") int amt) {
		ResponseEntity<Object> response = null;
		try {
			service.transfer(did,cid,dpwd,amt);
			CustomResponse data = new CustomResponse();
			data.setMsg(" Amount of "+amt+" succesfully transfered from Account with an id "+did+" to an Account with id "+cid);
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		} catch(AccountNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		} catch(PassowrdMismatchException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}catch(InsufficientBalanceException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
}
