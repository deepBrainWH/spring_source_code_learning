package org.springsource.course1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springsource.course1.cap1.Person;
import org.springsource.course1.cap10.bean.Bird;
import org.springsource.course1.cap10.config.Cap10Configuration;
import org.springsource.course1.cap11.Cap11MainConfigure;
import org.springsource.course1.cap11.MyController;
import org.springsource.course1.cap11.MyService;
import org.springsource.course1.cap12.Cap12Configuration;
import org.springsource.course1.cap12.Light;
import org.springsource.course1.cap12.Moon;
import org.springsource.course1.cap12.Sun;
import org.springsource.course1.cap13.Cap13Configuration;
import org.springsource.course1.cap13.service.CalculateService;
import org.springsource.course1.cap2.config.MainConfig2;
import org.springsource.course1.cap4.MainConfig;
import org.springsource.course1.cap5.Cap5MainConfig;
import org.springsource.course1.cap6.Cap6MainConfig;
import org.springsource.course1.cap7.Cap7MainConfig;
import org.springsource.course1.cap8.bean.Jeep;
import org.springsource.course1.cap9.Cap9MainConfigOfLifeCycle;
import org.springsource.course1.cap9.Train;
import org.springsource.course1.cap8.config.Cap8MainConfigOfLifeCycle;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Date: 1/12/20
 * Author: wangheng
 * Description: 测试类
 **/
public class MainTest3 {

    private static final Log log = LogFactory.getLog(MainTest3.class);

    /**
     * 测试扫描配置类
     */
    @Test
    public void testComponentScan() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    /**
     * 测试单例bean模式
     */
    @Test
    public void testSingletonBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Object person1 = context.getBean("person1");
        Object person2 = context.getBean("person1");
        log.info(person1 == person2);
    }

    /**
     * 测试懒加载, (懒加载主要针对单实例bean)
     */
    @Test
    public void testLazeLoad() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(org.springsource.course1.cap3.MainConfig.class);
        log.info("IOC容器初始化完成");
        Person person = (Person) context.getBean("person");
        log.debug(person + "====");
    }

    /**
     * 测试cap4. 条件注册bean
     */
    @Test
    public void testCap4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            log.info(name);
        }
        log.info("IOC容器初始化完成!");
    }

    /**
     * 测试cap5: 导入自定义类
     */
    @Test
    public void testImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap5MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            log.info(name);
        }
        log.info("IOC容器初始化完毕");
    }

    /**
     * 测试ImportBeanDefinitionRegistrar
     */
    @Test
    public void testImportBeanDefinitionRegistrar() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap6MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            log.info(name);
        }
    }

    /**
     * Test FactoryBean
     */
    @Test
    public void testFactoryBean() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap7MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            log.info(name);
        }
        Object bean1 = context.getBean("jamesFactory");
        Object bean2 = context.getBean("&jamesFactory");
        log.info("Bean类型:" + bean1.getClass());
        log.info("Bean类型:" + bean2.getClass());
    }

    @Test
    //测试Bean的生命周期
    public void testTheLifecycleOfBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap8MainConfigOfLifeCycle.class);
        Object bike = context.getBean("bike");
        context.close();
    }

    /**
     * 测试bean的init, destroy方法, 通过实现接口来完成
     */
    @Test
    public void testTheLifecycleOfBean2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap8MainConfigOfLifeCycle.class);
        Train bean = context.getBean(Train.class);
        context.close();
    }

    @Test
    public void testTheLifecycleOfBean3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap8MainConfigOfLifeCycle.class);
        Jeep bean = context.getBean(Jeep.class);
        context.close();
    }

    @Test
    public void testBeanPostProcessor(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap9MainConfigOfLifeCycle.class);
        context.close();
    }

    @Test
    public void testCap10(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap10Configuration.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name: beanDefinitionNames){
            System.out.println("Beans: "+name);
        }
        //Printing all environment variables
        ConfigurableEnvironment environment = context.getEnvironment();

        System.out.println("Environment: == "+environment.getProperty("bird.color"));
        Bird bean = context.getBean(Bird.class);
        System.out.println(bean.toString());
    }

    @Test
    public void testCap11(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap11MainConfigure.class);
        MyController bean = context.getBean(MyController.class);
        MyService service = bean.getService();//从controller中获取service
        System.out.println(service.a);
        MyService bean1 = context.getBean("myService", MyService.class);//直接从容器中去拿
        System.out.println(bean1.a);
    }

    /**
     * 测试@Autowired在方法上
     */
    @Test
    public void testCap12(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap12Configuration.class);
        Sun bean = context.getBean(Sun.class);
        System.out.println(bean);
        Moon bean1 = context.getBean(Moon.class);
        System.out.println(bean1);
        context.close();
    }

    /**
     * 测试Aware
     */
    @Test
    public void testCap12Resolve(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap12Configuration.class);
        Light light = context.getBean("light", Light.class);
        context.close();
    }

    /**
     * test AOP
     */
    @Test
    public void testCap13(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap13Configuration.class);
        CalculateService bean = context.getBean(CalculateService.class);
        bean.div(14, 7);
        context.close();
    }
}
