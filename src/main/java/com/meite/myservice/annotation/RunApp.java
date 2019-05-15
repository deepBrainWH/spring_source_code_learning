package com.meite.myservice.annotation;

import com.meite.myservice.annotation.context.MyClassPathAnnotationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class RunApp {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //1. 扫描包
        MyClassPathAnnotationContext context = new MyClassPathAnnotationContext("com.meite.myservice.annotation.service");
        ArrayList<String> classNamesFromPackage = context.getClassNamesFromPackage();
        System.out.println("hello world");
        //2. 判断是否有注入Bean的注解

        //3. 使用Java反射机制进行初始化
    }
}
