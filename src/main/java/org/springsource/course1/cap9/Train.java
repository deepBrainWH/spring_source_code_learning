package org.springsource.course1.cap9;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by wangheng at 2/4/20
 * Description: 如果不指定init, destroy方法时, 同样可以通过实现InitializingBean和DisposableBean接口来完成
 **/
@Component
public class Train implements InitializingBean, DisposableBean {

    public Train(){
        System.out.println("调用构造方法");
    }
    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     * 当spring环境(context)关闭后调用此方法
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("调用销毁方法");
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     * 调用构造方法之后调用.
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用初始化方法");
    }
}
