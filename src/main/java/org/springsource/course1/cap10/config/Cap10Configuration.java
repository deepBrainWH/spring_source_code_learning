package org.springsource.course1.cap10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springsource.course1.cap10.bean.Bird;

/**
 * Date: 1/17/20
 * Author: wangheng
 * Description:bean的生命周期
 **/
@Configuration
@PropertySource(value = "classpath:/test.properties")
public class Cap10Configuration {

    @Bean
    public Bird bird(){
        return new Bird();
    }
}
