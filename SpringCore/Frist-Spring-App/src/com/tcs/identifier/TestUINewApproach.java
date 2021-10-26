package com.tcs.identifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUINewApproach {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
		ID i = (ID)con.getBean("i1");
		i.display();
		((ClassPathXmlApplicationContext)con).close();
	}

}
