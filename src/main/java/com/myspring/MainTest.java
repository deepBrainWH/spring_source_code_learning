package com.myspring;

import com.myspring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService)context.getBean("userServiceImp");
//        userService.add();
//        userService.anno_transactionAdd();
        userService.update();
//        userService.update1();
    }
}
