package com.tcs.service;

import com.tcs.dao.CustomerDao;

/*
 * This is a Service that depends on DAO
 */
public class CustomerService {
	// you can initialize the dao either through setter-injection
	// or constructor-injection
	private CustomerDao customerDao;
	// constructor to initialize the CustomerDao
	public CustomerService(CustomerDao dao) {
		this.customerDao = dao;
	}
	public void testDependencies() {
		System.out.println("testDependencies of Customer Service");
		customerDao.connect();
	}
}
