package com.meite.myservice.xml;

import com.meite.myservice.xml.context.exception.BeanException;
import com.meite.myservice.xml.context.support.MyClassPathXmlContext;
import com.meite.myservice.xml.service.UserService;
import org.dom4j.DocumentException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static Main main = new Main();

    public static void main(String[] args) throws DocumentException,
            ClassNotFoundException, InstantiationException, BeanException, IllegalAccessException {
//        new Main().spring();
        main.mySpring();
//        new MyClassPathXmlContext("meite/myspring.xml");
    }

    private void spring(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("meite/myspring.xml");
        UserService userService = (UserService)context.getBean("userService");
        System.out.println(userService);
    }

    private void mySpring() throws DocumentException, ClassNotFoundException,
            InstantiationException, BeanException, IllegalAccessException {
        MyClassPathXmlContext myClassPathXmlContext = new MyClassPathXmlContext("meite/myspring.xml");
        UserService userService = (UserService)myClassPathXmlContext.getBean("userService");
        System.out.println(userService);

    }
}
