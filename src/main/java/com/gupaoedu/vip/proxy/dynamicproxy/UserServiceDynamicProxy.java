package com.gupaoedu.vip.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceDynamicProxy implements InvocationHandler{

	private UserService service;
	
	public Object getInstance(UserService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
		return Proxy.newProxyInstance(this.service.getClass().getClassLoader(),
				this.service.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("dynamic proxy end!");
		Object invoke = method.invoke(service, args);
		System.out.println("Dynamic proxy start!");
		return invoke;
	}

}
