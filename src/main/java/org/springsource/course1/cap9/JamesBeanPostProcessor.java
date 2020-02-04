package org.springsource.course1.cap9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by wangheng at 2/4/20
 * Description:
 **/
@Component
public class JamesBeanPostProcessor implements BeanPostProcessor {

    /**
     * init之前调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("call : postProcessBeforeInitialization" + "---beanName: " + beanName);
        return null;
    }

    /**
     * init之后调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("call : postProcessAfterInitialization" + "---beanName: " + beanName);
        return null;
    }
}
