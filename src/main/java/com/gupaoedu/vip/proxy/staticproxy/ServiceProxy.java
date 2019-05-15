package com.gupaoedu.vip.proxy.staticproxy;

public class ServiceProxy {
	private UserService userService;
	
	public ServiceProxy(UserService service) {
		this.userService = service;
	}
	
	public void add() {
		System.out.println("static proxy : start transaction...");
		this.userService.add();
		System.out.println("static proxy : stop transaction...");;
	}
	
	
}
