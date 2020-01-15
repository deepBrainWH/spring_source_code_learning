package org.springsource.course1.cap7;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springsource.course1.cap5.Cat;
import org.springsource.course1.cap5.Dog;
import org.springsource.course1.cap5.JamesImportSelector;
import org.springsource.course1.cap6.JamesImportBeanDefinitionRegistrar;

/**
 * Date: 1/14/20
 * Author: wangheng
 * Description: 自定义组件添加到bean扫描中.
 **/
@Configuration
public class Cap7MainConfig {
    /**
     * 使用beanFactory注册Bean.
     */
    //容器启动时初始化Person的bean实例

}
