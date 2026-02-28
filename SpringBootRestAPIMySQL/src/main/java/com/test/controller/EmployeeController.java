package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee/v1/api")
@Tag(name = "Employee CRUD Operations")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping(value="/create")
	@Operation(summary = "Create Employee")
	public ResponseEntity<Employee> createBook(@RequestBody Employee emp){
		Employee eobj = service.saveEmployee(emp);
		if(eobj != null) {
			return new ResponseEntity<>(eobj,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(eobj,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/list")
	@Operation(summary = "Listing all employees")
	public ResponseEntity<List<Employee>> listAllEmployee(){
		List<Employee> list = service.getAllEmployees();
		if(list.size() > 0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id){
		Optional<Employee> eobj = service.getEmployeeById(id);
		 
		if(eobj != null) {
			return new ResponseEntity<>(eobj,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(eobj,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee emp) {
		emp.setId(id);
		Employee eobj = service.updateEmployee(emp);
		if(eobj != null) {
			return new ResponseEntity<>(eobj,HttpStatus.ACCEPTED); 
		}else {
			return new ResponseEntity<>(eobj,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<List<Employee>> deleteEmployeeById(@PathVariable int id){
		List<Employee> list = service.deleteEmployeeById(id);
		if(list.size() > 0) {
			return new ResponseEntity<>(list,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byname/{name}")
	@Operation(summary = "get emp by name")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name){
		Employee eobj = repository.getEmployeeByName(name);
		if(eobj != null) {
			return new ResponseEntity<>(eobj,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(eobj,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/bycmp/{company}")
	@Operation(summary = "get emp by company")
	public ResponseEntity<List<Employee>> getEmployeeByCompany(@PathVariable String company){
		List<Employee> list = repository.getEmployeesByCompany(company);
		if(list.size() > 0) {
			return new ResponseEntity<>(list,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
}
