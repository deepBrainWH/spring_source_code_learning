# spring
## 第一节课
### 1. IOC容器相关 (org.springsource.course1.cap1, org.springsource.course1.cap2)
IOC容器其实就是个很大的map集合  
IOC容器: 多实例->仅当bean被使用时才创建  
        单实例->创建IOC容器时bean就被创建

直接使用`@Bean`默认是单例模式的bean, 如果想指定以多例模式创建bean, 在`@Bean`注解之前(或者之后)加上
`@Scope(value="prototype")`注解. *注: 单例模式: @Scope(value="singleton")*  
使用`@ComponentScan`注解定义扫描类型时, 如果使用到自定义过滤器`@ComponentScan.@Filter`时, includeFilter use false
要不然使用默认的加载会失败.  
`@ComponentScan` 会将 `@Controller`, `@Service`, `@Repository`, `@Conponent`都扫描进来.  
@Scope(value = "")//scope的value四个取值
1. prototype: 多实例, IOC容器启动的时候,IOC容器并不会去调用方法创建对象, 而是每次获取的时候才会调用方法创建对象.  
2. singleton: 单实例(默认): IOC容器启动时会调用方法创建对象并且放入到IOC容器中, 以后每次获取就是直接从IOC容器中拿对象(Map.get())  
4. request: 主要针对web应用, 递交一次请求创建一个实例  
5. session: 同一个session创建了一个实例
### 2. 懒加载 (org.springsource.course1.cap3)
懒加载: 主要针对单实例bean, 默认容器启动时创建bean, 指定懒加载(@Lazy)时, 容器启动的时候不创建对象,仅当第一次使用(或者获取)
时创建bean.
## 第二节课
### 条件注册bean (org.springsource.course1.cap4)
> 其实IOC就是对我们的bean进行注册管理实例化, 因此会讲很多关于bean的管理的知识点.

有些情况下, 我们需要选择性的注入一些bean, 比如使用条件过滤, 在Windows下注入一些bean, 在Linux下注入另外一些bean, 此时就会使用到
条件注册bean功能

FactoryBean, BeanFactory区别?  
--> FactoryBean是一种注册机制, 可以把我们java实例bean通过factoryBean注入到容器中.  
--> BeanFactory: 从我们容器中获取到实例化后的bean.  
### 手动添加组件到IOC容器(Spring注册Bean的多种注册方式)
3. @Import: [快速给容器导入一个组件] 注意: @Bean有点简单粗暴.
   3.1 `@Import()`导入容器中的组件, 容器会自动注册这个组件, bean的id为全类名.
   3.2 ImportSelector: 是一个接口, 返回需要导入到容器的组件的全类名.
   3.3 ImportBeanDefinitionRegistrar: 可以手动加组件到IOC容器中, 所有Bean注册可以使用BeanDefinitionRegistrar
        定义一个类实现BeanDefinitionRegistrar接口即可.
`@Import()`导入容器中的组件, 容器会自动注册这个组件, bean的id为全类名, 其实就是实例化bean的另一种方式

4. 实现ImportBeanDefinitionRegistrar接口, 可以条件注册bean
```java
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
            BeanDefinition beanDefinition = new RootBeanDefinition("pig", Pig.class);
            registry.registerBeanDefinition("pig");
        }
    }
}
```
5. 使用Spring提供的FactoryBean(工厂bean)进行注册
## 第三节课 Bean的生命周期
### 初始化--销毁bean的三种方式
1. `@Bean(initMethod= , destroyMethod= )`
2. Bean类中实现 InitializingBean, DisposableBean接口
3. JSR250规范: `@PostConstruct`, `@PreDestroy`注解  
底层源码实现, 位置:org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory  
![源码实现](./imgs/1.png)

### 自定义bean后置处理器  
代码位置:`org.springsource.course1.cap9.JamesBeanPostProcessor`  
步骤:
1. 创建并初始化容器相关的所有processor
2. bean

### 关于Spring Bean后置处理器`BeanPostProcessor`
> 注意区分bean实现InitializingBean、DisposableBean接口和定义BeanPostProcessor的区别
定义一个类实现BeanPostProcessor接口后, 实现两个方法， beforeInitializer和afterInitializer方法， 是针对所有bean初始化处理。

其实对于`@Autowired`注解, 实际上是`AutowiredAnnotationBeanPostProcessor`类所完成的操作.  
Autowired----->AutowiredAnnotationBeanPostProcessor  注册到IOC容器  
bean----->控制我们的bean  

## 第四节课 beanPostProcessor及其组件的使用
`@Autowired` `@Service` `@Inject` `@Qualifier` `@Resource`  
1. `@Value("${name}")` : 给bean属性进行赋值, 从.properties文件中取值  
### @Autowired @Qualifier @Primary自动装配
什么是自动装配?  
    Spring利用依赖注入, 完成对容器中哥哥组件依赖关系的赋值.  
思考与操作?  
 - bean组件加载优先级?  
 - 如果容器中存在两个id相同的bean, 会加载那个bean呢?  
 - 容器加载不存在的bean会出现什么问题?  
 - @Primary注解bean首选如何使用? 
 - @Autowired和@Resource和@Inject区别? 

将同一个bean注入以相同的名字注入两次, configuration中的注入不起作用的. 默认使用@Autowired注入的bean  
![](./imgs/3.png)![](./imgs/4.png)  
如果同一个bean使用不同的名字注入两次, 会报异常:
```
No qualifying bean of type 'org.springsource.course1.cap11.MyService' available: expected single matching bean but found 2: myService,myService--
org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.springsource.course1.cap11.MyService' available: 
expected single matching bean but found 2: myService,myService--
```
Bean Id不能相同.  @Qualifier("beanId")指定到容器中找id为beanId的注入的bean  
@Primary注解标注作为首选bean注入. 一般在Config配置类中和@Bean联合使用.   

同样@Resource也可以把指定beanId注入. 即:`@Resource("beanId")` = `@Autowired + @Qualifier("beanId")`  
`@Resource()`不支持`@Primiary`, @Resource是JDK中的规范, 不是spring中的东西.  
`@Inject`方式注入bean是JSR250规范, 需要引入javax.inject version=1依赖包, @Inject功能和@Autowired差不多.
支持@Primiary, 但是没有@Autowired中required=false功能. @Inject不依赖spring.  
## 第五节课: SpringAOP
spring 启动过程:  
容器启动加载配置类-->refresh()-->finishBeanFactoryInitialization()-->getBean()-->
doCreateBean()-->beanWrapper(对象创建)-->populated(属性赋值)-->initialize()-->processors  
IOC: 核心就是完成bean初始化丢到容器中(把bean放到大Map集合中)  
### 关于Aware接口
1. ApplicationContextAware接口: 获取到spring上下文环境(context)
2. BeanNameAware接口: 获取到beanName
3. EmbeddedValueResolverAware接口: 属性赋值, 等价于`@Value()`, `@Value`参数: ${} 取环境变量值，　#{} springel表达式求值.

手写IOC容器步骤:  
IOC{  
//加载properties  
//声明MAP集合  
//JamesComponentScan() A B C三个类 controller service dao FILE[] file  
//利用反射机制 class.forName()将这些类加载尽力啊, 得到实例  
//将实例put到Map集合中.   
}  
总结: 把Spring底层的组件可以通过实现Aware相关接口注入到自定义bean中, ApplicationContextAware是利用ApplicationContextAwareProcessor
来处理的, 其他XXXAware也类似, 都有相关的Processor来处理, XXXAware-->功能使用了XXXProcessor来处理的;  
比如: ApplicationContextAware-->ApplicationContextProcessor后置处理器来处理的.  
### Spring AOP
前置通知: logStart(), 在目标方法(div)运行之前运行(@Before)  
后置通知: logEnd()  
返回通知: logReturn()  
异常通知: logException()  
环绕通知: 动态代理, 最底层通知, 手动指定执行目标方法(@Around)  
> 注意: Around通知在@Before通知之前.  

