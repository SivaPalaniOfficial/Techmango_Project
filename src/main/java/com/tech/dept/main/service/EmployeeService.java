package com.tech.dept.main.service;

import java.util.List;
import com.tech.dept.main.entity.Employee;
import com.tech.dept.main.error.EmployeeNotFoundException;

public interface EmployeeService {

	public Employee saveNewEmp(Employee emp);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException;

	public Employee getEmployeeByFirstName(String empName);

	public void deleteEmployeeById(Long id);

	public Employee updateEmployeeById(Long id, Employee emp);

	public List<Employee> getEmployeeListByEmpAge(int age);

	public List<Employee> getEmployeeByDeptNameWithSQL(String deptName);
}
