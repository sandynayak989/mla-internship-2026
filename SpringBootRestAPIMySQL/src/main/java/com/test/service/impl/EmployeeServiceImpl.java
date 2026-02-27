package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import com.test.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empDao;
	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.saveEmployee(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.saveEmployee(emp);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		empDao.deleteEmployeeById(id);
		return empDao.getAllEmployees();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees();
	}

}
