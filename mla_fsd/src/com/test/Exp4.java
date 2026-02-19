package com.test;

//exceptions -> all runtime errors are exceptions
//handling -> giving user friendly message

public class Exp4 {
	public static void main(String[] args) {
		//System.out.println("MLA");
		//System.out.println(11/12);
		//System.out.println("coders");
		
		//String name = null; -> nullpointer exception
		
		//String name = "";
		//System.out.println(name.charAt(1)); -> stringOutOfBound exception
		//String name = "java";
		//System.out.println(name.charAt(1));
		
		//int[] arr = {2,3,4,5,6,7};
		
		//System.out.println(arr[5]);
		
		//int x = Integer.parseInt("22a3");
		
		//for compile time exception we need try catch to implement it
		
		//handling techniques
		try {
			System.out.println(11/0);
			String name1 = null;
			System.out.println(name1.equals("test"));
		}catch(ArithmeticException ae) {
			System.out.println("Can't divide by zero");
		}catch(NullPointerException npe) {
			System.out.println("Enter a value for string");
		}catch(Exception e){
			System.out.println("Try again");
		}finally { // always executes mostly used for garbage collection
			System.out.println("finally block");
		}
		
		
		
	}
}
