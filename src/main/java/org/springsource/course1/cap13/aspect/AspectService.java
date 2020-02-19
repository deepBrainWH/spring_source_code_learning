package org.springsource.course1.cap13.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by wangheng at 2/19/20
 * Description: 日志切面类
 **/
@Aspect
public class AspectService {
    private static final Log log = LogFactory.getLog(AspectService.class);

    @Pointcut("execution(public void org.springsource.course1.cap13.service.CalculateService.*(..))")
    public void pointCut1() {

    }

    //    @Before("execution(public int org.springsource.course1.cap13.service.CalculateService.div(int, int))")
//    @Before("execution(public int org.springsource.course1.cap13.service.CalculateService.*(int, int))")//固定两个int参数
    @Before("pointCut1()")//CalculateService类中任意方法,任意参数
    public void before(JoinPoint joinPoint) {
        log.info("运行before...");
    }

    @After("pointCut1()")
    public void after() {
        log.info("运行after...");
    }

    @AfterThrowing("pointCut1()")
    public void afterThrowing() {
        log.error("调用After throwing");
    }

    @AfterReturning("pointCut1()")
    public void afterReturning() {
        log.info("调用after return");
    }

    @Around("pointCut1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before Around");
        Object o = joinPoint.proceed();
        log.info("After Around");
        return o;
    }

}
