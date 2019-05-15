package com.gupaoedu.vip.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class GPMeipo implements MethodInterceptor{

	
	public Object getInstance(Object obj) throws Exception{
		
		Enhancer enhancer = new Enhancer();
		//设置父类
		//告诉cglib,生成的子类要继承那个类。
		enhancer.setSuperclass(obj.getClass());
		//设置回调。
		enhancer.setCallback(this);
		
		//1.生成源代码
		//2.编译成class文件
		//3.加载到JVM中，并返回被代理的对象
		return enhancer.create();
	}
	
	/**
	 * 同样是做了一件事：字节码充足
	 * 对于使用API的用户来说，是无感知的。
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, 
			MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("我是ＧＰ媒婆：　"+"得给你找个异性对象");
		System.out.println("开始进行海选.......");
		System.out.println("------------------------");

		/**
		 * 这个obj引用是由CGLbi 给我们new出来的
		 * cglib new出来以后的对象，是被代理的对象的子类（继承了我们自己写的那个类）
		 * OOP, 在new子类之前，实际上是先调用了我们super()方法的。
		 * new 了子类的同时，必须先new出父类，这就相当于是间接的持有了我们父类的引用
		 * 子类重写负责父类的所有方法
		 * 我们改变了子类对象的某些属性，是可以间接操作父类属性的
		 */
		proxy.invokeSuper(obj, args);
		System.out.println("------------------------");
		System.out.println("如果合适，准备办事----------");		
		return null;
	}	
}
