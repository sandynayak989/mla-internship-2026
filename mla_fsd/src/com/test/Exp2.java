package com.test;

@FunctionalInterface
interface FunInf{
	//can contain only 1 abstract method
	void draw();
	//void color(); -> leads to compile time error -> cannot have more than 1 abstract class
	default void dog() {
		
	}
	
	static void cat() {
		
	}
}

class Circle implements FunInf{
	@Override
	public void draw() {
		System.out.println("circle");
	}
}

class Square implements FunInf{
	@Override
	public void draw() {
		System.out.println("square");
	}
	
	//factory method
	public Square getObj() {
		System.out.println("object returned");
		return new Square();
	}
}

public class Exp2 {
	public static void main(String[] args) {
		Circle obj1 = new Circle();
		obj1.draw();
		Square obj2 = new Square();
		obj2.draw();
		
		//Square obj3 = obj2.getObj(); // factory method
		
		//lambda method instead of usual method
		FunInf obj3 = ()-> System.out.println("cicle");
		obj3.draw();
	}
}
