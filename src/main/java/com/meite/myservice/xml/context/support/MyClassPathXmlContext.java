package com.meite.myservice.xml.context.support;

import com.meite.myservice.xml.context.exception.BeanException;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.InputStream;
import java.util.List;

public class MyClassPathXmlContext {

    /**
     * 1. 解析XML文件
     * 2. 使用方法参数bean id查找配置文件中bean节点id信息是否一致。
     * 3. 获取class信息地址，使用反射机制初始化。
     */
    private static Logger logger = Logger.getRootLogger();

    //XML path
    private String xmlPath;

    public MyClassPathXmlContext(String xmlPath) throws DocumentException {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws BeanException, DocumentException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(beanId == null) throw new BeanException("Bean id 不能为空");
        //1. 获取所有Bean节点信息
        List<Element> elements = readXML();
        if(elements == null) throw new BeanException("配置文件中未查找到Bean");
        String objectPath = getObjectPath(beanId, elements);
        if(objectPath==null)throw new BeanException("该bean id未配置class地址");
        return initBean(objectPath);
    }

    private String getObjectPath(String beanId, List<Element> elements)
            throws BeanException {
        for (Element element: elements){
            String xmlBeanId = element.attributeValue("id");
            if(xmlBeanId == null){
                throw new BeanException("Can not find bean id.");
            }
            if(xmlBeanId.equals(beanId)){
                return element.attributeValue("class");
            }
        }
        return null;
    }

    private Object initBean(String clazz) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Class<?> forName = Class.forName(clazz);
        return forName.newInstance();
    }

    //解析XML文件
    private List<Element> readXML() throws DocumentException {
        //1.读取xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(getReaourceInputStream(xmlPath));
        //2. 读取根节点
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        return elements;
    }


    private InputStream getReaourceInputStream(String xmlPath) {
        return this.getClass().getClassLoader().getResourceAsStream(xmlPath);
    }

}
