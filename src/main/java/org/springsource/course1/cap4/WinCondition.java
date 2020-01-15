package org.springsource.course1.cap4;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Date: 1/14/20
 * Author: wangheng
 * Description: 条件注册bean, 设置匹配条件.
 **/
public class WinCondition implements Condition {
    /**
     *
     * @param context 判断条件可以使用的上下文(环境)
     * @param metadata 注解信息
     * @return 是否保留
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //能够取到IOC容器正在使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取当前环境变量(包括操作系统是win还是Linux)
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        if(osName.contains("Windows")){
            return true;
        }

        return false;
    }
}
