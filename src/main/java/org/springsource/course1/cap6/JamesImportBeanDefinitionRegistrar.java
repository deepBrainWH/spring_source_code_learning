package org.springsource.course1.cap6;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Date: 1/15/20
 * Author: wangheng
 * Description: ImportBeanDefinitionRegistrar
 **/
public class JamesImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata: 当前注解类信息
     * @param importingClassMetadata 当前注解类信息
     * @param registry beanDefinition注册类,
     *                 作用: 把所有需要添加到容器中的bean加入
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //实现功能: 只有当容器中有Dog和Cat对象时, 才向容器中加入Pig bean.
        boolean bean1 = registry.containsBeanDefinition("org.springsource.course1.cap5.Dog");
        boolean bean2 = registry.containsBeanDefinition("org.springsource.course1.cap5.Cat");
        //如果Dog和Cat同时存在于我们的IOC容器中, 那么创建Pig加入到容器中.
        if(bean1 && bean2){
            //对于我们要注册的bean, 给bean进行封装.
            //在底层源码中, 要想往容器中注册bean, 都会使用RootBeanDefinition类进行注册.
            //对bean进行一个封装.
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
//            BeanDefinition beanDefinition1 = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig", beanDefinition);
        }

    }
}
