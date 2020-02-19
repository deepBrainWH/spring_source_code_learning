package org.springsource.course1.cap12;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Created by wangheng at 2/19/20
 * Description:
 **/
@Component
public class Light implements BeanNameAware, ApplicationContextAware, EmbeddedValueResolverAware {
    private static final Log log = LogFactory.getLog(Light.class);

    private String beanName;
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        log.info("setBeanName.....");
        this.beanName = beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext.....");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        log.info("setEmbeddedValueResolver......");
        String result = resolver.resolveStringValue("你好${os.name}, 计算#{3*8}");
        log.info("输出结果为: " + result);
    }
}
