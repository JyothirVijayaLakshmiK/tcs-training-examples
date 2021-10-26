
package com.tcs.business;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.beans.Employee;
import com.tcs.dao.EmployeeDao;
import com.tcs.exception.EmployeeNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public Employee store(Employee employee) {
		int result = employeeDao.save(employee);
		Employee emp = employeeDao.fetchEmployee(result);
		return emp;
	}

	@Override
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
		Employee emp = employeeDao.fetchEmployee(id);
		if(emp == null) {
			throw new EmployeeNotFoundException("Sorry "+id+" not found!");
		}
		return emp;
	}
	@Override
	@Transactional
	public void updateEmploye(Employee emp) {
		employeeDao.updateEmployee(emp);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.fetchEmployees();
	}

	@Override
	public List<Employee> getEmployeesOrderByName() {
		List<Employee> employees = getEmployees();
		Collections.sort(employees,(x,y)->x.getName().compareTo(y.getName()));
		return employees;
	}
	/*@Override
	public List<Employee> getEmployeesOrderByName() {
		List<Employee> employees = getEmployees();
		Collections.sort(employees, new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		return employees;
	}*/

}
