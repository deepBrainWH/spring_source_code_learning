package org.springsource.course1.cap1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springsource.course1.cap1.Person;

/**
 * Date: 1/10/20
 * Author: wangheng
 * Description:
 **/
@Configuration
public class MainConfig {

    @Bean(value = "abc")
    public Person person(){
        return new Person("james", "male", 20);
    }
}
