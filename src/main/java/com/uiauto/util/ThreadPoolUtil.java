package com.uiauto.util;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtil {
    /*private ThreadPoolUtil(){};
    public static ThreadPoolUtil getInstance(){
        return new ThreadPoolUtil();
    }*/

    /**
     *创建一个容量为10的线程池
     */
    /**
     *ThreadPoolUtil.getFixedThreadPol().execute(new Runnable(){public void run (){}});
     */
    public static ExecutorService getFixedThreadPool(){
        return Executors.newFixedThreadPool(10);
    }
    public static void main(String[]args){
        ThreadPoolUtil.getFixedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试测试！");
            }
        });
    }
}
