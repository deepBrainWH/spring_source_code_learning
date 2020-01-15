package org.springsource.course1.cap3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springsource.course1.cap1.Person;

/**
 * Date: 1/10/20
 * Author: wangheng
 * Description:懒加载测试配置
 **/
@Configuration
public class MainConfig {

    @Bean
    @Lazy
    public Person person(){
        System.out.println("给容器中添加person");
        return new Person("james", "male", 20);
    }
}
