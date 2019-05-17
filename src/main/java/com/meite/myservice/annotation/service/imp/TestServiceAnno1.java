package com.meite.myservice.annotation.service.imp;

import com.meite.myservice.annotation.annotation.MyService;

@MyService
public class TestServiceAnno1 {

    public TestServiceAnno1(){
        System.out.println("Test service ANNO1 被调用！");
    }

    public void callMyself(){
        System.out.println(this.getClass().getSimpleName() + " 被调用！ call myself");
    }
}
