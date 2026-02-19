package com.test;

interface Inf1{
	float pi = 3.14f;//public static final pi = 3.14f;
	
	void disp(); //public abstract void disp();
	void cat();
	default void human() {
		System.out.println("default inf");
		animal();
	}
	
	static String greetUser(String msg) {
		return msg;
	}
	
	private void animal() {
		System.out.println("private method");
	}
	
	//interface cannot have constructors
	/*public Inf1(){}*/
	
	
}

interface Inf2{
	void book();
}

abstract class Abs1{
	public Abs1() {
		System.out.println("Constructor");
	}
	
	public abstract void fox();
	
	public void color() {
		System.out.println("implemented method abs1");
	}
}

//one class can extend only one class (abstract or normal)
//one class can implement many interfaces
class Impl1 extends Abs1 implements Inf1,Inf2{
	@Override
	public void fox() {
		System.out.println("abs implemented");
	}
	@Override
	public void book() {
		System.out.println("inf2 implemented");
	}
	@Override
	public void disp() {
		System.out.println("inf1 implemented");
	}
	@Override
	public void cat() {
		System.out.println("inf1 implemented");
	}
}

public class Exp1 {
	
	public static void main(String[] args) {
		Impl1 obj=new Impl1();
		//non static methods can be accessed using obj method
		obj.book();
		obj.disp();
		obj.cat();
		obj.human();
		obj.fox();
		obj.color();
		//dynamic binding
		
		
		
		// static methods cannot override and is class level so cannot be used in another location.
		System.out.println(Inf1.greetUser("Hello MLA coders..."));
	}
	
}

/*
 * Ways we can create object for class
 * Using New operator
 * using factory method
 * using clone() method
 * using Class.forName() method -> dynamic object creation
 * */

