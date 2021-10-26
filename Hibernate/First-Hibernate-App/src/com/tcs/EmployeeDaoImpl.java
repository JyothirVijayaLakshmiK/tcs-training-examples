package com.tcs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDaoImpl {
	public int store(Employee employee) {
		int key = 0;
		SessionFactory factory = HibernateUtil.createSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		key = (int)session.save(employee); 
		transaction.commit();
		session.close();
		factory.close();
		return key;
	}
	public void deleteById(Employee employee) {
		SessionFactory factory = HibernateUtil.createSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(employee); 
		System.out.println("Employee data deleted");
		transaction.commit();
		session.close();
		factory.close();
	}
	public void updateSalary(Employee employee) {
		SessionFactory factory = HibernateUtil.createSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee); 
		System.out.println("Employee salary updated");
		transaction.commit();
		session.close();
		factory.close();
	}
	public Employee fetchEmployee(int empId) {
		Employee employee = null;
		SessionFactory factory = HibernateUtil.createSessionFactory();
		Session session = factory.openSession();
		employee = session.get(Employee.class, empId);  
		session.close();
		factory.close();
		return employee;
	}
	public List<Employee> fetchEmployees() {
		List<Employee> employees = null;
		SessionFactory factory = HibernateUtil.createSessionFactory();
		Session session = factory.openSession();
		Query<Employee> query = session.createQuery("select e from Employee e", Employee.class);
		employees = query.getResultList();
		session.close();
		factory.close();
		return employees;
	}
	
}
