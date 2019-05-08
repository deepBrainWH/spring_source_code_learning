package gupaoedu.vip.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {
		//被代理对象
		UserService service = new UserServiceImp();
		//代理人
		UserServiceDynamicProxy dynamicProxy = new UserServiceDynamicProxy(service);
		
		Object newProxyInstance = Proxy.newProxyInstance(UserService.class.getClassLoader(), 
				UserService.class.getInterfaces(), dynamicProxy);
		
	}
}
