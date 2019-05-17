package com.meite.myservice.annotation;

import com.meite.myservice.annotation.app.MySpringBootApplication;
import com.meite.myservice.annotation.service.imp.AnnoServiceImp;

import java.io.IOException;
import java.net.URISyntaxException;

public class RunApp {

    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        MySpringBootApplication.run(RunApp.class);
        AnnoServiceImp annoServiceImp = (AnnoServiceImp)new MySpringBootApplication().getBean("service");
//        TestServiceAnno testServiceAnno = (TestServiceAnno)new MySpringBootApplication().getBean("testServiceAnno");
        annoServiceImp.callAutowriteObject();
    }

    private void myAnnotationService() throws IOException, URISyntaxException {
        //2. 判断是否有注入Bean的注解

        //3. 使用Java反射机制进行初始化
    }
}
