package com.test.cls;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
public class Exp4 {
	public static void main(String[] args) {
		//HashMap<String, Integer> data = new HashMap<>();
		//LinkedHashMap<String, Integer> data = new LinkedHashMap<>();
		TreeMap<String, Integer> data = new TreeMap<>();
		data.put("sony",330);
		data.put("lenovo",320);
		data.put("dell",200);
		data.put("apple",350);
		data.put("dell",400);
		data.put("sony",5030);
		//data.put(null, 11); null cannot be used as treemap key
		
		data.forEach((k,v)-> System.out.println(k+" : "+v));
		
		System.out.println(data.get("sony"));
	}
}
