package org.springsource.course1.cap11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangheng at 2/16/20
 * Description:
 **/
@Service
public class MyService {
    public int a = 1;

    @Autowired
    private MyDao myDao;

    public void printService() {
        System.out.println(myDao);
        System.out.println("test--service");
    }
}
