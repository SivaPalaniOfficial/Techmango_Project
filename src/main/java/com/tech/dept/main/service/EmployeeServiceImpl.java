package com.tech.dept.main.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tech.dept.main.entity.Employee;
import com.tech.dept.main.error.EmployeeNotFoundException;
import com.tech.dept.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee saveNewEmp(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
		
		Optional<Employee> emp = repo.findById(id);
        if(!emp.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return  emp.get();
	}

	@Override
	public Employee getEmployeeByFirstName(String empName) {
		return repo.findByFirstName(empName);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee emp) {
		
		Employee empp = repo.findById(id).get();
		log.info("department by id-->" +empp);
		
		empp.setFirstName(emp.getFirstName());
		empp.setLastName(emp.getLastName());
		empp.setAge(emp.getAge());
		emp.setDept(emp.getDept());
		return repo.save(empp);
	}

	@Override
	public List<Employee> getEmployeeListByEmpAge(int age) {
		return repo.getByAge(age);
	}

	@Override
	public List<Employee> getEmployeeByDeptNameWithSQL(String deptName) {
		return repo.getEmployeeDeptWithSQL(deptName);
	}
}
