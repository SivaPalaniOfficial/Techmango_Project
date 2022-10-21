package com.tech.dept.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tech.dept.main.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public Employee findByFirstName(String empName);

	@Query(value = "select * from employee_tbl where emp_dept=?1", nativeQuery = true)
	public List<Employee> getEmployeeDeptWithSQL(String deptName);

	public List<Employee> getByAge(int age);
}
