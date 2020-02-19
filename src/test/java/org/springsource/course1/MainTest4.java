package org.springsource.course1;

import org.springframework.scheduling.annotation.Async;

/**
 * Created by wangheng at 2/11/20
 * Description:
 **/
public class MainTest4 {

    @Async
    public void async() throws InterruptedException {
        System.out.println("hello world");
        Thread.sleep(5000);
    }
    public void test() throws InterruptedException {
        async();
        System.out.println("test被执行了!");
    }
    public static void main(String[] args) throws InterruptedException {
        new MainTest4().test();
    }
}
