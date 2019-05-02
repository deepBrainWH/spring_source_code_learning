package gupaoedu.vip.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class GPMeipo implements MethodInterceptor{

	
	public Object getInstance(Object obj) throws Exception{
		
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(obj.getClass());
		
		enhancer.setCallback(this);
		
		
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
		proxy.invokeSuper(obj, args);
		System.out.println("------------------------");
		System.out.println("如果合适，准备办事----------");		
		return null;
	}	
}
