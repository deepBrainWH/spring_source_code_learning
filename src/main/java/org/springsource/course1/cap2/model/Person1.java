package org.springsource.course1.cap2.model;

/**
 * Date: 1/12/20
 * Author: wangheng
 * Description: model测试类
 **/
public class Person1 {
    String name;
    String sex;

    public Person1(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
