package com.test.dao;

import java.util.List;
import java.util.Optional;

import com.test.entity.Customer;

public interface CustomerDao {
	public Customer saveCustomer(Customer cust);
	public Customer updateCustomer(Customer cust);
	public Optional<Customer> getCustomerById(int id);
	public List<Customer> deleteCustomerById(int id);
	public List<Customer> getAllCustomer();
}
