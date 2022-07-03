package com.hln.thread.线程执行顺序;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("这是A线程");
        },"A").start();
        new Thread(()->{
            System.out.println("这是B线程");
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行程序");
        },"B").start();
        new Thread(()->{
            System.out.println("这是C线程");
        },"C").start();
        new Thread(()->{
            System.out.println("这是D线程");
        },"D").start();
        new Thread(()->{
            System.out.println("这是E线程");
        },"E").start();
        new Thread(()->{
            System.out.println("这是F线程");
        },"F").start();
        new Thread(()->{
            System.out.println("这是G线程");
        },"G").start();
        new Thread(()->{
            System.out.println("这是H线程");
        },"H").start();
        new Thread(()->{
            System.out.println("这是J线程");
        },"J").start();

    }
}
