package org.springsource.course1.cap11;

import org.springframework.stereotype.Repository;

/**
 * Created by wangheng at 2/16/20
 * Description:
 **/
@Repository
public class MyDao {

    private final String version = "123l";

    public void printDao(){
        System.out.println("Print dao");
    }

    @Override
    public String toString() {
        return version;
    }
}
