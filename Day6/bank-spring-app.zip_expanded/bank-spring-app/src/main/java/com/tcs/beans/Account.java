package com.tcs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Account")
public class Account {
	@Column(name="accountno")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountno;
	@Column(name="username")
	private String name;
	@Column(name="DOB")
	private Date dateofbirth;
	@Column(name="balance")
	private int balance;
	@Column(name="password")
	private String password;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dob) {
		this.dateofbirth = Date.valueOf(dob);
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int bal) {
		this.balance = bal;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pswd) {
		this.password = pswd;
	}
	
}
