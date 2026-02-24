package com.test;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class ConnectionManager {
	
	private boolean isConnected = false;
	
	@PostConstruct
	public void connect() {
		System.out.println("Connecting to external service");
		isConnected = true;
		System.out.println("connection estabkished isConnect");
	}
	
	@PreDestroy
	public void disconnect() {
		System.out.println("Disconnectig from external servive");
		isConnected = false;
		System.out.println("Connection cloed");
	}
	
	public void operation() {
		if(isConnected) {
			System.out.println("performing operation with active service");
		}else {
			System.out.println("Operation failed not connected");
		}
	}
}
