package org.springsource.course1.cap12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangheng at 2/19/20
 * Description:
 **/
@Component
public class Sun {
    private Moon moon;

    public Moon getMoon(){
        return moon;
    }

//    public Sun(@Autowired Moon moon){
//        this.moon = moon;
//    }

    @Autowired
    public void setMoon(@Autowired Moon moon){
        this.moon = moon;
    }

    @Override
    public String toString() {
        return "Sun [Moon = "+moon+"]";
    }
}
