package com.greatlearning.springrest.dao;

import java.util.List;

import com.greatlearning.springrest.entity.Employee;

public interface EmployeeDaoI {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
