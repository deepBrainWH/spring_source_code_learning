package com.myspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//切面类
@Component
@Aspect
public class  AopLog {
    /**
     * aop编程里面有几个通知：前置通知，后置通知，运行通知，异常通知，环绕通知
     */
    @Before("execution(* com.myspring.service.UserService.add(..))")
    public void before(){
        System.out.println("前置通知， 在方法之前通知...");
    }

    @After("execution(* com.myspring.service.UserService.add(..))")
    public void after(){
        System.out.println("后置通知, 在方法之后执行...");
    }

    //异常通知
    @AfterThrowing("execution(* com.myspring.service.UserService.add(..))")
    public void afterThrowing(){
        System.out.println("异常通知...");
    }

    //运行通知
    @AfterReturning("execution(* com.myspring.service.UserService.add(..))")
    public void running(){
        System.out.println("运行通知...");
    }

    //环绕通知
    @Around("execution(* com.myspring.service.UserService.add(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //调用方法之前执行
        System.out.println("环绕通知调用方法之前执行");
        joinPoint.proceed();//代理调用方法， 注意点：如果调用方法抛出异常，不会执行后面代码
        //调用方法之后执行
        System.out.println("环绕通知，调用方法之后执行");
        return null;
    }

}
