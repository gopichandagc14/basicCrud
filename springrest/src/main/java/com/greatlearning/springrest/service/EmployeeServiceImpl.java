package com.greatlearning.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.greatlearning.springrest.dao.*;
import com.greatlearning.springrest.entity.Employee;
import com.greatlearning.springrest.repository.RepositoryI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private RepositoryI repository;
	
	//private EmployeeDaoI employeeDao;
	
/*
	@Autowired
	public EmployeeServiceImpl(EmployeeDaoI employeeDao) {
		this.employeeDao = employeeDao;
	}
	*/
	
	@Override
	public List<Employee> findAll() {
		//return employeeDao.findAll();
		return repository.findAll();
	}

	@Override
	public Optional<Employee> findById(int theId) {
	
		//return employeeDao.findById(theId);
		return repository.findById(theId);
	}

	@Override
	public void save(Employee theEmployee) {
		//employeeDao.save(theEmployee);
		repository.save(theEmployee);
		
		
	}

	@Override
	public void deleteById(int theId) {
		//employeeDao.deleteById(theId);
		repository.deleteById(theId);
	}

}
