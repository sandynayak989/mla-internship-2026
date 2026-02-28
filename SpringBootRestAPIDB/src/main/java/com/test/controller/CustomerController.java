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

import com.test.entity.Customer;
import com.test.repository.CustomerRepository;
import com.test.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/customer/v1/api")
@Tag(name = "Customer CRUD Operations")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping(value="/create")
	@Operation(summary = "Create Customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer cust){
		Customer cobj = service.saveCustomer(cust);
		if(cobj != null) {
			return new ResponseEntity<>(cobj,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/list")
	@Operation(summary = "Listing all Customer")
	public ResponseEntity<List<Customer>> listAllCustomer(){
		List<Customer> list = service.getAllCustomer();
		if(list.size() > 0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int id){
		Optional<Customer> cobj = service.getCustomerById(id);
		 
		if(cobj != null) {
			return new ResponseEntity<>(cobj,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable int id, @RequestBody Customer cust) {
		cust.setId(id);
		Customer cobj = service.updateCustomer(cust);
		if(cobj != null) {
			return new ResponseEntity<>(cobj,HttpStatus.ACCEPTED); 
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable int id){
		List<Customer> list = service.deleteCustomerById(id);
		if(list.size() > 0) {
			return new ResponseEntity<>(list,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byname/{name}")
	@Operation(summary = "get emp by name")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable String name){
		Customer cobj = repository.getCustomerByName(name);
		if(cobj != null) {
			return new ResponseEntity<>(cobj,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.NOT_FOUND);
		}
	}

}
