package org.springsource.course1.cap8.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by wangheng at 2/4/20
 * Description: JSR250标准初始化bean的生命周期
 **/
@Component
public class Jeep {
    public Jeep(){
        System.out.println("调用构造方法--Jeep");
    }
    @PostConstruct
    public void init(){
        System.out.println("调用初始化方法--Jeep");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("调用销毁方法--Jeep");
    }


}
