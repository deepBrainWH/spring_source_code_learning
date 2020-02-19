package org.springsource.course1.cap12;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.security.auth.Destroyable;

/**
 * Created by wangheng at 2/19/20
 * Description:
 **/
@Component
public class Moon implements InitializingBean, DisposableBean {

    public Moon(){
        System.out.println("Moon constructor");
    }

    public void init(){
        System.out.println("Moon init...");
    }

    @Override
    public void destroy(){
        System.out.println("Moon destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
