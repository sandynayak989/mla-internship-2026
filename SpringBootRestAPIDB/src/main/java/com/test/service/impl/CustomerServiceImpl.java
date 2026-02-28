package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao custDao;
	
	@Override
	public Customer saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return custDao.saveCustomer(cust);
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return custDao.saveCustomer(cust);
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		return custDao.getCustomerById(id);
	}

	@Override
	public List<Customer> deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		custDao.deleteCustomerById(id);
		return custDao.getAllCustomer();
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return custDao.getAllCustomer();
	}

}
