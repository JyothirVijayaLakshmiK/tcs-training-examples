package com.tcs.business;

import java.util.List;

import com.tcs.beans.Employee;
import com.tcs.exception.EmployeeNotFoundException;

public interface EmployeeService {
	public Employee store(Employee employee);
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException;
	public void updateEmploye(Employee emp);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesOrderByName();
}
