package com.tcs.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestBeanScope {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Test t1 = (Test)context.getBean("t");
		Test t2 = (Test)context.getBean("t");	
		((ClassPathXmlApplicationContext)context).close();
	}

}
