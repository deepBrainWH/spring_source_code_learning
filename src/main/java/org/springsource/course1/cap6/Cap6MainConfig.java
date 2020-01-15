package org.springsource.course1.cap6;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springsource.course1.cap5.Cat;
import org.springsource.course1.cap5.Dog;
import org.springsource.course1.cap5.JamesImportSelector;

/**
 * Date: 1/14/20
 * Author: wangheng
 * Description: 自定义组件添加到bean扫描中.
 **/
@Configuration
@Import(value = {Dog.class, Cat.class, JamesImportSelector.class,
        JamesImportBeanDefinitionRegistrar.class})
public class Cap6MainConfig {
    /**
     * 1. @Bean: 局限性: [导入第三方类或者包的组件], 比如Person为第三方类, 需要在我们的IOC容器中使用
     * 2. 包扫描+组件的标注注解(@ComponentScan: @Controller, @Service, @Repository, @Component)一般是针对我们自己写的类
     * 3. @Import: [快速给容器导入一个组件] 注意: @Bean有点简单粗暴.
     *   3.1 `@Import()`导入容器中的组件, 容器会自动注册这个组件, bean的id为全类名.
     *   3.2
     */
    //容器启动时初始化Person的bean实例

}
