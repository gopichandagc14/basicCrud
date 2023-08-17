package com.greatlearning.springrest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greatlearning.springrest.entity.Employee;
import com.greatlearning.springrest.rest.EmployeeRestController;
import com.greatlearning.springrest.service.EmployeeServiceI;

@WebMvcTest(EmployeeRestController.class)
public class InitialTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EmployeeServiceI employeeServiceI;
	
	@Autowired
	ObjectMapper objectMapper;
	

	
	Optional<Employee> optEmployee = Optional.of(new Employee(1,"Muffy", "Indore", "muffy@indore.com"));
	
	
	//Optional<UserDetails> userDetailsById=Optional.of(new UserDetails( 1, "ram", "a@gmail.com", "hyd", "mca","ram"));
	
/*
	void getUserDetailsById() throws Exception {
		when(userService.getUserDetailsById(1)).thenReturn(userDetailsById);
		Optional<UserDetails> us=userService.getUserDetailsById(1);
		assertEquals("ram",us.get().getFullName());
		verify(userService, times(1)).getUserDetailsById(1);
		}   

	*/
	
	@Test
	public void findById() {
		
		when(employeeServiceI.findById(1)).thenReturn(optEmployee);		
		Optional<Employee> employee = employeeServiceI.findById(1);		
		assertEquals("Muffy", employee.get().getFirstName() );
		verify(employeeServiceI,times(1)).findById(1);
	}
	


	
}
