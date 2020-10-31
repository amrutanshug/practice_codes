package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> retrieveAll(){
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		System.out.println(employees);
		return employees;
	}
	
	public void addEmployee (Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee (int id, Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);	
	}

	public Optional<Employee> retrieveById(int id) {
		return employeeRepository.findById(id);
	}

}
