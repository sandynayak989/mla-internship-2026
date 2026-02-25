package com.test.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspectJoinPoint {
	
	@Before("execution(public void com.test.model..set*(*)")
	public void loggingAdvice(JoinPoint joinpoint) {
		System.out.println("Before executing loggingAdvice");
		System.out.println("Argments passed: "+Arrays.toString(joinpoint.getArgs()));
	}
	
	@Before("args(name)")
	private void logStringArguments(String name) {
		System.out.println("string arguments passed: "+name);
	}
}
