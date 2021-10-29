package com.tcs.beans;

public class Transaction {
	private long transactionId;
	private long accountNumber;
	private double amount;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(long transactionId, long accountNumber, double amount) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
