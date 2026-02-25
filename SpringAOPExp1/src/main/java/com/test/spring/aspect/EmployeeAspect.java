package com.test.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	@Before("execution(public String getName())")
	private void getNameAdvice() {
		System.out.println("Executing advice on getName() method");
		
	}
	
	@Before("execution(* com.test.service.*.get*())")
	private void getAllAdvice() {
		System.out.println("service method getter call");

	}
}
