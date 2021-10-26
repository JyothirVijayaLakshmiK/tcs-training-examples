package com.tcs.viewcontroller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tcs.service.CustomerService;

/*
 * Assume this as a controller & view 
 */
public class TestViewController {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// you are using a fully configured object i.e., CustomerService
		CustomerService service = (CustomerService)context.getBean("service");
		service.testDependencies();
		((ClassPathXmlApplicationContext)context).close();
	}

}
