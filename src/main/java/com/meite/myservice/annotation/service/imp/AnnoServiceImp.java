package com.meite.myservice.annotation.service.imp;

import com.meite.myservice.annotation.annotation.MyAutowrite;
import com.meite.myservice.annotation.annotation.MyService;
import com.meite.myservice.annotation.service.AnnoService;

@MyService(name = "service")
public class AnnoServiceImp implements AnnoService {

    @MyAutowrite
    private TestServiceAnno serviceAnno;

    public AnnoServiceImp(){
        System.out.println("调用构造方法, 获取到对象");
    }

    public void callAutowriteObject(){
        serviceAnno.called();
    }

    public void callMySelf(){
        System.out.println(this.getClass().getSimpleName() + " Call myself");
    }

}
