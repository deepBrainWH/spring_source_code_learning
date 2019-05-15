package com.gupaoedu.vip.factory.func;

public class TestFactoryInter {

	public static void main(String[] args) {
		Factory fac = new AudiFactory();
		String name = fac.getVehicle().getName();
		System.out.println(name);
	}
}
