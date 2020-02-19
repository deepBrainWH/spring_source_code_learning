package org.springsource.course1.cap13.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * Created by wangheng at 2/19/20
 * Description:
 **/
public class CalculateService {

    public void div(int i, int j){
        System.out.println(i/j);
    }
}
