package com.greatlearning.springrest.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.springrest.entity.Employee;
import com.greatlearning.springrest.service.EmployeeServiceI;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeServiceI employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeServiceI theEmpService) {
		this.employeeService = theEmpService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable int employeeId) {
		Optional<Employee> theEmployee = employeeService.findById(employeeId);
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
		return "deleted the employee with id : "+employeeId;
	}
}
