package org.springsource.course1.cap7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 1/14/20
 * Author: wangheng
 * Description: 自定义组件添加到bean扫描中.
 **/
@Configuration
public class Cap7MainConfig {
    /**
     * 使用beanFactory注册Bean.
     */
    //容器启动时初始化Person的bean实例
    @Bean("jamesFactory")
    public JamesFactoryBean jamesFactory(){
        return new JamesFactoryBean();
    }
}
