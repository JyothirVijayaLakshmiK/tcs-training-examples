package com.tcs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestStoreEmployee {
	public static void main(String[] args) {
		// Obtaining the SessionFactory from the Utility class
		SessionFactory factory = HibernateUtil.createSessionFactory();
		// 3rd step is to create Session to perform CRUD operations
		Session session = factory.openSession();
		Employee employee1 = new Employee();
		employee1.setName("Charles");
		employee1.setSalary(46200);
		
		Employee employee2 = new Employee();
		employee2.setName("David");
		employee2.setSalary(77200);
		// 4th step create transaction to perform store
		Transaction transaction = session.beginTransaction();
		// 5th step is to perform store 
		session.save(employee1); // stores the employee1 to the Employee
		session.save(employee2); // stores the employee2 to the Employee table
		// commit the changes using transaction.commit()
		transaction.commit();
		
		// last step is to close Session & SessionFactory
		session.close();
		factory.close();
		System.out.println("---- Saved Successfully -----");
	}

}
