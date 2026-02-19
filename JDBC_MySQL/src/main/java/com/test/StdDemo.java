package com.test;

import java.util.List;

public class StdDemo {

	public static void main(String[] args) {
		StudentDao sdao = new StudentDao();
		Student std1 = new Student();
		std1.setId(3);
		std1.setAge(25);
		std1.setName("cena");
		std1.setCity("Hyderabad");
		 
		//sdao.saveStudent(std1); //insert
		//sdao.updateStudent(std1); //update
		//sdao.deleteStudent(2);//delete
		System.out.println("updated employee data");
		
		List<Student> data = sdao.getAllStudent();
		data.forEach(System.out::println);
		
		System.out.println("abc");

	}

}
