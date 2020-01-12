package org.springsource.course1.cap2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springsource.course1.cap2.controller.OrderController;

/**
 * Date: 1/10/20
 * Author: wangheng
 * Description:
 **/
@Configuration
@ComponentScan(value = "org.springsource.course1.cap2", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {OrderController.class}
                /**
                 * excludeFilters时, userDefaultFilter=true,
                 * 使用includeFilters时, useDefaultFilters=false
                */
        )
}, useDefaultFilters = false)//扫描包注解
public class MainConfig {

}
