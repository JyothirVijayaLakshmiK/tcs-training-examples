package com.tcs.service;


import com.tcs.beans.Account;
import com.tcs.exceptions.AccountNotFoundException;
import com.tcs.exceptions.InsufficientBalanceException;
import com.tcs.exceptions.PasswordMismatchException;

public interface AccountService {
	public Account register(Account accountno);
	public Account fetchAccountById(int accountno) throws AccountNotFoundException;
	public Account fetchAccountByIdandPassword(int accountno,String password) throws AccountNotFoundException,PasswordMismatchException;
	public void transfer(int debitoraccountno,int creditoraccountno,String debitorpassword,int amount) throws InsufficientBalanceException,PasswordMismatchException,AccountNotFoundException;
	public void updatePassword(int accountno, String oldpassword, String newpassword)  throws AccountNotFoundException,PasswordMismatchException;
}
