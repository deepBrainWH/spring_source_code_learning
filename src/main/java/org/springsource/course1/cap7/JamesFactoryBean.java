package org.springsource.course1.cap7;

import org.springframework.beans.factory.FactoryBean;
import org.springsource.course1.cap6.Pig;

/**
 * Date: 1/15/20
 * Author: wangheng
 * Description:
 **/
public class JamesFactoryBean implements FactoryBean<Pig> {
    @Override
    public Pig getObject() throws Exception {
        return new Pig();
    }

    @Override
    public Class<?> getObjectType() {
        return Pig.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
