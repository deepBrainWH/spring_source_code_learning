package org.springsource.course1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springsource.course1.cap1.Person;

/**
 * Date: 1/10/20
 * Author: wangheng
 * Description:
 **/
public class MainTest1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)context.getBean("person");
        System.out.println(person.getName() + "==" + person.getSex() + "==" + person.getAge());
    }
}
