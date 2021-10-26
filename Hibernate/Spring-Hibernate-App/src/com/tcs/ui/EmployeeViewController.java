package com.tcs.ui;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tcs.beans.Employee;
import com.tcs.business.EmployeeService;
import com.tcs.exception.EmployeeNotFoundException;

public class EmployeeViewController {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
		Scanner scan = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("Enter the option");
			System.out.println("1: Store employee 2: Get employee 3: Get all employees "
					+ "4: Update Salary 5: Update Name 6: Sort employees by name 7: Exit");
			option = scan.nextInt();
			switch(option) {
			case 1: 
				Employee e = new Employee();
				System.out.println("Enter name");
				e.setName(scan.next());
				System.out.println("Enter salary");
				e.setSalary(scan.nextDouble());
				Employee storedEmployee = employeeService.store(e);
				System.out.println("Hello, "+storedEmployee.getName()+", your id is : "+storedEmployee.getId());
				break;
			case 2: 
				System.out.println("Enter id");
				try {
					Employee emp = employeeService.findEmployeeById(scan.nextInt());
					System.out.println("Employee found.");
					System.out.println("Id: "+emp.getId()+", Name: "+emp.getName()+", Salary: "+emp.getSalary());
				} catch (EmployeeNotFoundException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			case 3: 
				List<Employee> list = employeeService.getEmployees();
				for(Employee it : list) {
					System.out.println("Id: "+it.getId()+", Name: "+it.getName()+", Salary: "+it.getSalary());
				}
				break;
			case 4:
			try {
				System.out.println("Enter id");
				Employee emp1 = employeeService.findEmployeeById(scan.nextInt());
				System.out.println("Employee found.");
				System.out.println("Enter salary");
				emp1.setSalary(scan.nextDouble());
				employeeService.updateEmploye(emp1);
			} catch (EmployeeNotFoundException e1) {
				System.err.println(e1.getMessage());
			}
				break;
			case 5: 
				try {
				System.out.println("Enter id");
				Employee emp2 = employeeService.findEmployeeById(scan.nextInt());
				System.out.println("Employee found.");
				System.out.println("Enter name");
				emp2.setName(scan.next());
				employeeService.updateEmploye(emp2);
			} catch (EmployeeNotFoundException e1) {
				System.err.println(e1.getMessage());
			}
				break;
			case 6: 
				List<Employee> employeesList = employeeService.getEmployeesOrderByName();
				for(Employee it : employeesList) {
					System.out.println("Id: "+it.getId()+", Name: "+it.getName()+", Salary: "+it.getSalary());
				}
				break;
			}
		} while(option != 7);
		System.out.println("Program Exits!");
		scan.close();
		((ClassPathXmlApplicationContext)context).close();
	}

}
