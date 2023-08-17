package com.greatlearning.springrest.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.springrest.entity.Employee;

public interface EmployeeServiceI {

	public List<Employee> findAll();
	public Optional<Employee> findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
	
}
