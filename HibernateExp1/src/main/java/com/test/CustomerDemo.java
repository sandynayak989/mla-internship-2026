package com.test;

import java.util.List;

public class CustomerDemo {

	public static void main(String[] args) {
		CustomerDao cdao = new CustomerDao();
		
		Customer cst = new Customer();
		
		cst.setC_id(1);
		cst.setC_name("samm");
		cst.setC_city("karachi");
		//cdao.saveCustomer(cst);
		//cdao.updateCustomer(cst);
		cdao.deleteCustomer(cst);
		List<Customer> list = cdao.getAllCustomers();
//		for(Customer b : list) {
//			System.out.println(b.getC_id()+" "+b.getC_name()+" "+b.getC_city());
//		}
		
		
		list.forEach(System.out::println);
		System.out.println("Success");

	}

}
