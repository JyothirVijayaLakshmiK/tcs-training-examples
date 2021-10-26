package com.tcs.service;


import com.tcs.beans.Account;
import com.tcs.exceptions.*;

public interface AccountService {
	public Account register(Account account);
	public Account fetchAccountById(int accountno) throws AccountNotFoundException;
	public Account fetchAccountByIdandPassword(int accountno,String password) throws AccountNotFoundException,PasswordMismatchException;
	public void transfer(int daccountno,int caccountno,String dpassword,int amount) throws AccountNotFoundException,PasswordMismatchException,InsufficientBalanceException;
	public void updatePassword(int accountno, String oldpassword, String newpassword)  throws AccountNotFoundException,PasswordMismatchException;
}
