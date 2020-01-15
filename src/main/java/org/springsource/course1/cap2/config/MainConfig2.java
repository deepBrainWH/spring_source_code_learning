package org.springsource.course1.cap2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springsource.course1.cap2.model.Person1;

/**
 * Date: 1/12/20
 * Author: wangheng
 * Description: 测试单实例和多实例bean
 **/
@Configuration
public class MainConfig2 {

    @Bean
    @Scope(value = "prototype")
    public Person1 person1(){
        return new Person1("wangheng", "male");
    }
}
