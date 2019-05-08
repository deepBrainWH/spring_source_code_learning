package com.myspring.aop;

import com.myspring.tansaction.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
@Aspect
public class MyTransaction {

    @Autowired
    private TransactionUtils transactionUtils;

    //环绕通知
    @Around("execution(* com.myspring.service.UserService.anno_*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //调用方法之前执行
        System.out.println("start transaction");
        TransactionStatus status = transactionUtils.begin();
        joinPoint.proceed();//代理调用方法， 注意点：如果调用方法抛出异常，不会执行后面代码
        //调用方法之后执行
        transactionUtils.commit(status);
        System.out.println("commit transaction");
        return null;
    }

    //异常通知
    @AfterThrowing("execution(* com.myspring.service.UserService.anno_*(..))")
    public void afterThrowing(){
        //获取当前事务，直接回滚
        System.out.println("rollback transaction");
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
