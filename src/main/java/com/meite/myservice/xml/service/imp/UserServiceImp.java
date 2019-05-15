package com.meite.myservice.xml.service.imp;

import com.meite.myservice.xml.service.UserService;

public class UserServiceImp implements UserService {
    public UserServiceImp(){
        System.out.println("反射创建实例");
    }
}
