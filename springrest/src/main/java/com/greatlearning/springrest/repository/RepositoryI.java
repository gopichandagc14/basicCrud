package com.greatlearning.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.springrest.entity.Employee;

public interface RepositoryI extends JpaRepository<Employee, Integer>{

}
