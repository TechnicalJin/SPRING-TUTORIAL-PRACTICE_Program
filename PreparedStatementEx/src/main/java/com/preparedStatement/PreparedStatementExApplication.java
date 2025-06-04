package com.preparedStatement;

import com.preparedStatement.dao.EmployeeDao;
import com.preparedStatement.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class PreparedStatementExApplication {

	public static void main(String[] args) {
		System.out.println("Program Started..");

		ApplicationContext context = new ClassPathXmlApplicationContext("XML/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");

		Employee employee = new Employee(101, "Ajay", 43000);
		boolean isInserted = employeeDao.saveEmployeeByPreparedStatement(employee);

		if (isInserted) {
			System.out.println("Employee Inserted Successfully..");
		} else {
			System.out.println("Failed to Insert Employee..");
		}

		List<Employee> list = employeeDao.getAllEmployees();
		for (Employee e : list){
			System.out.println(e);
		}
	}
}


// CREATE FIRST DATABASE NAMED jdbcpractice2;
// THEN RUN PROGRAM