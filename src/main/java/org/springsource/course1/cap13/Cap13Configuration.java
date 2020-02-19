package org.springsource.course1.cap13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springsource.course1.cap13.aspect.AspectService;
import org.springsource.course1.cap13.service.CalculateService;

/**
 * Created by wangheng at 2/19/20
 * Description:AOP测试配置类
 * 日志切面类的方法需要动态感知到div()方法运行
 * 通知方法:
 * 前置通知: logStart(); 在我们div()除法之前运行  @Before
 * 后置通知: 在我们目标方法div()运行结束之后, 不管有没有异常, 都会执行后置通知 @After
 * 返回通知: logReturn(): 在我们目标方法执行正常返回值后运行 @AfterReturn
 * 异常通知: logException(): 在我们目标方法div出现异常后运行;@AfterThrowing
 * 环绕通知: 动态代理, 执行joinPoint.proceed() @Around
 * 针对五种通知, 都提供了相应的注解.
 */
@Configuration
@EnableAspectJAutoProxy//开启AspectJ注解
public class Cap13Configuration {

    @Bean
    public CalculateService calculateService(){
        return new CalculateService();
    }
    @Bean
    public AspectService aspectService(){
        return new AspectService();
    }
}
