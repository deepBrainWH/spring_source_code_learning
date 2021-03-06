package org.springsource.course1.cap5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springsource.course1.cap1.Person;

/**
 * Date: 1/14/20
 * Author: wangheng
 * Description: 自定义组件添加到bean扫描中.
 **/
@Configuration
@Import(value = {Dog.class, Cat.class, JamesImportSelector.class})
public class Cap5MainConfig {
    /**
     * 1. @Bean: 局限性: [导入第三方类或者包的组件], 比如Person为第三方类, 需要在我们的IOC容器中使用
     * 2. 包扫描+组件的标注注解(@ComponentScan: @Controller, @Service, @Repository, @Component)一般是针对我们自己写的类
     * 3. @Import: [快速给容器导入一个组件] 注意: @Bean有点简单粗暴.
     *   3.1 `@Import()`导入容器中的组件, 容器会自动注册这个组件, bean的id为全类名.
     *   3.2
     */
    //容器启动时初始化Person的bean实例
    @Bean("person")
    public Person person(){
        return new Person("person", "male", 20);
    }

    @Bean("lison")
    public Person person1(){
        return new Person("lison", "male", 40);
    }
    @Bean("james")
    public Person person2(){
        return new Person("james", "male", 50);
    }

}
