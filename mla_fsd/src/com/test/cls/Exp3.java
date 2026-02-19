package com.test.cls;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Iterator;


public class Exp3 {
	public static void main(String[] args) {
		
		//HashSet data = new HashSet();
		//LinkedHashSet data = new LinkedHashSet();
		//TreeSet data = new TreeSet(); ->by default arranges one type of ascending order
		//multiple data types will result in error
		TreeSet<String> data = new TreeSet();
		
		data.add("java");
		data.add("test");
		data.add("dotnet");
		
		System.out.println(data);
		System.out.println(data.size());
		
//		Iterator ltr = data.iterator();
		
//		while(ltr.hasNext()) {
//			System.out.println(ltr.next());
//		}
		//or
		data.forEach(System.out::println);
	}
}
