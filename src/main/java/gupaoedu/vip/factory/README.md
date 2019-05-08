### Design pattern -- Factory design pattern
```
In class-based programming, the **factory method pattern** is a creational pattern that uses factory  
methods to deal with the problem of creating objects without having to specify the exact class of  
the object that will be created. This is done by creating objects by calling a factory method  
—either specified in an interface and implemented by child classes, or implemented in a base  
class   and optionally overridden by derived classes—rather than by calling a constructor.  
```  
+ 把复杂的逻辑处理过程隐藏掉，只关心执行结果。
+ 简单工厂、工厂方法、抽象工厂

Spring 中的工厂模式：
* Bean
	* BeanFactory(生成Bean)
	* 单例的Bean
	* 被代理过的Bean
	* 最原始的Bean(原型）
	* List 类型的Bean
	* 作用域不同的Bean
* getBean()方法生成Bean
* 最终目的：松耦合开发（解耦， 低耦合，高聚合）
