package com.gupaoedu.vip.factory.abstrfac;

public class TestAbstractFactory {
	public static void main(String[] args) {
		DefaultFactory factory = new DefaultFactory();
		
		System.out.println(factory.getCar().getName());
		
		System.out.println(factory.getCar("BMW").getName());
	}
}
