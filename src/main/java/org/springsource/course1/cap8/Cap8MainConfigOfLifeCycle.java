package org.springsource.course1.cap8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springsource.course1.cap1.Person;

/**
 * Date: 1/17/20
 * Author: wangheng
 * Description:bean的生命周期
 **/
@Configuration
public class Cap8MainConfigOfLifeCycle {

    @Bean
    public Person person(){
        System.out.println("给容器添加Bean");
        return new Person("wangheng", "male", 22);
    }

    /**
     * 指定初始化方法名, 销毁方法名
     * @return bean实例
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Bike bike(){
        return new Bike();
    }
}
