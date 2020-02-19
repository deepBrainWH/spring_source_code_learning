package org.springsource.course1.cap11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by wangheng at 2/16/20
 * Description:
 **/
@Controller
public class MyController {

    @Qualifier("myService2")
    @Autowired
    private MyService myService;

    public MyService getService(){
        return this.myService;
    }

}
