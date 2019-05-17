package com.meite.myservice.annotation.service.imp;

import com.meite.myservice.annotation.annotation.MyAutowrite;
import com.meite.myservice.annotation.annotation.MyService;

@MyService(name = "testServiceAnno")
public class TestServiceAnno {

    @MyAutowrite
    private TestServiceAnno1 serviceImp;

    public TestServiceAnno(){
        System.out.println("test service Anno 调用构造方法");
    }

    public void called(){
        System.out.println("我被调用了。");
        serviceImp.callMyself();
    }
}
