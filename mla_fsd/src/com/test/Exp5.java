package com.test;

public class Exp5 {
	public static void main(String[] args) {
		try {
			System.out.println(11/0);
		}catch(Exception e) {
			//getMessage() 
			System.out.println(e.getMessage()); //o/p: / by zero
			
			//printing exception class object
			System.out.println(e);// o/p: java.lang.ArithmeticException: / by zero
			
			//printing stacktrace
			e.printStackTrace(); //o/p: java.lang.ArithmeticException: / by zero at com.test.Exp5.main(Exp5.java:6)
		}
	}
}
