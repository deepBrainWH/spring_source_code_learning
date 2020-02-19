package org.springsource.course1.cap10.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by wangheng at 2/16/20
 * Description:
 **/

public class Bird {

    //使用@Value进行赋值: 1.使用基本字符 2.spring el表达式 3.读取.properties配置文件
    @Value("james")
    private String name;
    //注意: 使用springel表达式赋值
    @Value("#{20-2}")
    private int age;

    @Value("${bird.color}")
    private String color;

    public Bird() {
    }

    public Bird(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "name:"+this.getName()+" age: "+this.getAge()+" color: "+this.color;
    }
}
