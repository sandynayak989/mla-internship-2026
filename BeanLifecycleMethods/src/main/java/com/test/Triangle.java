package com.test;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements InitializingBean,DisposableBean{
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw() {
		System.out.println("position A is:("+pointA.getX()+" , "+pointA.getY()+")");
		System.out.println("position B is:("+pointB.getX()+" , "+pointB.getY()+")");
		System.out.println("position B is:("+pointC.getX()+" , "+pointC.getY()+")");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DisposableBean destroy method is called for triangle");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("InitializingBean init method is called for triangle");
		
	}
	
	public void customInit() {
		System.out.println("Custom init() called for triangle");
	}
	
	public void cleanUp() {
		System.out.println("Custom celanup() called for triangle");
	}
	
}
