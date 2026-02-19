package com.test;

import java.util.List;

public class TestDemo {

	public static void main(String[] args) {
		EmpDao edao = new EmpDao();
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("sandy");
		emp1.setCmp("MNO");
		emp1.setCity("Mangalore");
		 
		//edao.saveEmployee(emp1); //insert
		//edao.updateEmployee(emp1); //update
		edao.deleteEmployee(2);//delete
		System.out.println("updated employee data");
		
		List<Employee> data = edao.getAllEmployees();
		data.forEach(System.out::println);

	}

}
