package com.tcs.dao;

import java.util.List;

import com.tcs.beans.Employee;

public interface EmployeeDao {
	public int save(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee fetchEmployee(int id);
	public List<Employee> fetchEmployees();
}
