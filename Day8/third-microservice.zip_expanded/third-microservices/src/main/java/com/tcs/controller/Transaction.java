package com.tcs.controller;

public class Transaction {
	private long transId;
	private long accountNo;
	private double amount;
	
	public Transaction() {
		super();
	}
	public Transaction(long transId, long accountNo, double amount) {
		super();
		this.transId = transId;
		this.accountNo = accountNo;
		this.amount = amount;
	}
	public long getTransactionId() {
		return transId;
	}
	public void setTransactionId(long transId) {
		this.transId = transId;
	}
	public long getAccountNumber() {
		return accountNo;
	}
	public void setAccountNumber(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
