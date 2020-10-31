package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.service.EmployeeService;

@RestController
public class CrudController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String home () {
		return "home";	
	}
	
	
	@GetMapping("/getAllEmployees")
	public List<Employee> retrieveAll () {
		return employeeService.retrieveAll();	
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Optional<Employee> retrieveById (@PathVariable int id) {
		return employeeService.retrieveById(id);	
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
	public void addEmployee (@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@PutMapping("/addEmployee")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee.getId(), employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void updateEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
	
}
