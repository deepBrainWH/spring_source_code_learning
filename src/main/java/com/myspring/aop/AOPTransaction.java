package com.myspring.aop;

import com.myspring.tansaction.TransactionUtils;
import com.myspring.tansaction.annotation.ExtTransaction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

@Aspect
@Component
public class AOPTransaction {
    private final TransactionUtils transactionUtils;

    public AOPTransaction(TransactionUtils transactionUtils) {
        this.transactionUtils = transactionUtils;
    }

    @Around("execution(* com.myspring.service.*.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /**
         * 1.获取代理对象方法
         * 2. 获取该方法上是否加了注解
         * 3. 如果存在事务注解，开启事务
         * 4. 调用目标代理对象方法
         * 5. 判断该方法上是否有注解
         * 6. 如果存在注解，提交事务。
         */
        ExtTransaction declaredAnnotation = getMyTransaction(proceedingJoinPoint);

        TransactionStatus transactionStatus = null;

        if(declaredAnnotation != null){
            transactionStatus = transactionUtils.begin();
        }
        proceedingJoinPoint.proceed();

        if(transactionStatus != null){
            transactionUtils.commit(transactionStatus);
        }
        return null;
    }

    @AfterThrowing("execution(* com.myspring.service.*.*.*(..))")
    public void afterThrowing(){
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        transactionUtils.rollback();
    }

    private ExtTransaction getMyTransaction(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        //1. 获取代理对象方法
        String name = proceedingJoinPoint.getSignature().getName();
        //2. 获取目标对象
        Class<?> classTarget = proceedingJoinPoint.getTarget().getClass();
        //获取目标对象类型
        Class<?>[] parameterTypes = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterTypes();
        //获取目标对象
        Method method = classTarget.getMethod(name, parameterTypes);

        return method.getDeclaredAnnotation(ExtTransaction.class);
    }
}
