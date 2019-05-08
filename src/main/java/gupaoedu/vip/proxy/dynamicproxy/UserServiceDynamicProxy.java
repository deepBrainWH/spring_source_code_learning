package gupaoedu.vip.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceDynamicProxy implements InvocationHandler{

	private UserService service;
	
	public UserServiceDynamicProxy(UserService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Dynamic proxy start!");
		Object invoke = method.invoke(service, args);
		System.out.println("dynamic proxy end!");
		return invoke;
	}

}
