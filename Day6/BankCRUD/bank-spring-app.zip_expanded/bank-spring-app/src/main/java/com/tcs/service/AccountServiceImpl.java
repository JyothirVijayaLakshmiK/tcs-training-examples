package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.beans.Account;
import com.tcs.dao.AccountRepository;
import com.tcs.exceptions.*;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository dao;
	
	@Override
	@Transactional
	public Account register(Account account) {
		return dao.save(account);
	}

	@Override
	public Account fetchAccountByIdandPassword(int accountno,String password) throws AccountNotFoundException,PasswordMismatchException {
		Account p = fetchAccountById(accountno);
		if(!p.getPassword().equals(password)){
			throw new PasswordMismatchException("Incorrect Password");
		}
		return p;
	}
	
	@Override
	public Account fetchAccountById(int accountno) throws AccountNotFoundException {
		Account p = dao.findById(accountno).orElse(null);
		if(p == null) {
			throw new AccountNotFoundException("Account with an id "+accountno+" not found");
		}
		return p;
	}

	@Override
	@Transactional
	public void transfer(int daccountno,int caccountno,String dpassword,int amount)throws AccountNotFoundException,PasswordMismatchException,InsufficientBalanceException{
		Account p = fetchAccountByIdandPassword(daccountno,dpassword);
		Account c = fetchAccountById(caccountno);
		if(p.getBalance()-amount>=0) {
			c.setBalance(p.getBalance()+amount);
			p.setBalance(p.getBalance()-amount);
		}
		else {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
	}

	@Override
	@Transactional
	public void updatePassword(int accountno, String oldpassword,String newpassword)throws AccountNotFoundException,PasswordMismatchException {
		Account p = fetchAccountByIdandPassword(accountno,oldpassword);
		p.setPassword(newpassword);
	}
}