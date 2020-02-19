package org.springsource.course1.cap9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by wangheng at 2/11/20
 * Description: 可以拿到applicationContext
 **/
@Component
public class Plane implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;

    private void print() {
        System.out.println("hello plane打印方法被打印 world");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //可以将applicationContext传进来, 可以拿到.
        this.applicationContext = applicationContext;
    }


    @Override
    public void afterPropertiesSet() {
        Plane bean = applicationContext.getBean(Plane.class);
        bean.print();
    }
}
