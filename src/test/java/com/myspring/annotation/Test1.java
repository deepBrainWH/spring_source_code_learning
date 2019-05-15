package com.myspring.annotation;

import java.lang.reflect.Method;

public class Test1 {

    @AddAnnotation(userName = "wangheng",usreId = 18, array = {"zhouaowei", "huanhuan"})
    public void add(){

    }

    public void del(){

    }

    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> forName = Class.forName("com.myspring.annotation.Test1");

        Method[] declaredMethods = forName.getDeclaredMethods();
        for(Method m: declaredMethods){
            AddAnnotation declaredAnnotation = m.getDeclaredAnnotation(AddAnnotation.class);
            if(declaredAnnotation == null){
                continue;
            }
            System.out.println("username : " + declaredAnnotation.userName());
            System.out.println("userId : " + declaredAnnotation.usreId());
            System.out.println("array : " + declaredAnnotation.array());
        }
    }
}
