package org.springsource.course1.cap4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springsource.course1.cap1.Person;

/**
 * Date: 1/10/20
 * Author: wangheng
 * Description:
 **/
@Configuration
public class MainConfig {

    @Conditional(WinCondition.class)
    @Bean("person")
    public Person person(){
        return new Person("person", "male", 20);
    }
    @Conditional(LinuxCondition.class)
    @Bean("lison")
    public Person person1(){
        return new Person("lison", "male", 40);
    }

    @Conditional(LinuxCondition.class)
    @Bean("james")
    public Person person2(){
        return new Person("james", "male", 50);
    }
}
