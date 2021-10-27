package com.tcs.controller;

public class Wallet {
	private long walletNumber;
	private double amount = 2000;
	public long getWalletNumber() {
		return walletNumber;
	}
	public void setWalletNumber(long walletNumber) {
		this.walletNumber = walletNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
