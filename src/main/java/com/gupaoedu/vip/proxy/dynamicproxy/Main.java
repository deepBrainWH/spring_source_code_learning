package com.gupaoedu.vip.proxy.dynamicproxy;

public class Main {
	public static void main(String[] args) {

		UserService instance = (UserService)new UserServiceDynamicProxy().getInstance(new UserServiceImp());
		instance.add();
	}
}
