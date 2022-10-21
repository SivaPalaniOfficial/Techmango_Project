package com.tech.dept.main.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dept.main.entity.Employee;
import com.tech.dept.main.error.EmployeeNotFoundException;
import com.tech.dept.main.service.EmployeeService;
import com.tech.dept.main.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/msg")
	public String getMst() {
		return "API Call working fine";
	}
	
	@PostMapping("/saveEmp")
	public Employee saveEmployee(@Valid @RequestBody Employee emp) {
		return service.saveNewEmp(emp);
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp(){
		return service.getAllEmployee();
	}
	
	@GetMapping("/getById/{id}")
	public Employee fetchById(@PathVariable("id") Long id ) throws EmployeeNotFoundException {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/getByFName/{name}")
	public Employee getByName(@PathVariable("name") String empName) {
		return service.getEmployeeByFirstName(empName);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		service.deleteEmployeeById(id);
		return "Employee deleted successfully";
	}
	
	@PutMapping("/updateById/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp) {
		return service.updateEmployeeById(id, emp);
	}
	
	@GetMapping("/getEmployeesByAge/{age}")
	public List<Employee> getEmpByAge(@PathVariable("age") int age) {
		log.info("Age coming from request-->"+age);
		return service.getEmployeeListByEmpAge(age);
	}
	
	@GetMapping("/getEmployeeByDeptNameWithSQL/{dept}")
	public List<Employee> getByCodeWithSQL(@PathVariable("dept") String deptName) {
		return service.getEmployeeByDeptNameWithSQL(deptName);
	}	
}













