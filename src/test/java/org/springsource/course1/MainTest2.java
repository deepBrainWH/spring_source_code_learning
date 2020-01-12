package org.springsource.course1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springsource.course1.cap1.Person;
import org.springsource.course1.cap1.config.MainConfig;

/**
 * Date: 1/10/20
 * Author: wangheng
 * Description:
 **/
public class MainTest2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person)context.getBean("abc");
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for(String name: beanNamesForType){
            System.out.println(name);
        }
        System.out.println(person.getName() + "==" + person.getSex() + "==" + person.getAge());
    }
}
