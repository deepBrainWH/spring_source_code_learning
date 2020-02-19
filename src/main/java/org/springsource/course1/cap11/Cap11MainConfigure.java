package org.springsource.course1.cap11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by wangheng at 2/16/20
 * Description:
 **/
@Configuration
@ComponentScan({"org.springsource.course1.cap11"})
public class Cap11MainConfigure {

    /**
     * 测试多次注入同一个bean
     */
    @Primary
    @Bean("myService2")
    public MyService myService(){
        MyService myService = new MyService();
        myService.a = 100;
        return myService;
    }
}
