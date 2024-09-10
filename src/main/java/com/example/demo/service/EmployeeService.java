package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public class EmployeeService {

	private List<Employee> employees = new ArrayList<>();

	public EmployeeService() {
		
		employees.add(new Employee(1, "Ankit", "Developer"));
		employees.add(new Employee(2, "Zamil", "Unit Head"));
	}

	
	public List<Employee> getAllEmployees() {
		return employees;
	}
}