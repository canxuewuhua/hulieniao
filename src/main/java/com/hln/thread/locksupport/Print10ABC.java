package com.hln.thread.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 打印10个ABC
 */
public class Print10ABC {
    static Thread t1 = null, t2= null, t3 = null;
    public static void main(String[] args) {
        t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print("A");
                // 获得一个票证 不能获得超过1个及以上
                LockSupport.unpark(t2);// 叫醒t2 这里注意：如果调用了unpark方法即使这个线程它准备睡它也不睡了
                // 释放一个票证
                LockSupport.park();// t1阻塞 当前线程阻塞
            }
        },"t1");
        t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();// t2阻塞 当前线程阻塞
                System.out.print("B");
                LockSupport.unpark(t3);// 叫醒t3 这里注意：如果调用了unpark方法即使这个线程它准备睡它也不睡了
            }
        },"t2");
        t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();// t3阻塞 当前线程阻塞
                System.out.print("C");
                LockSupport.unpark(t1);// 叫醒t1 这里注意：如果调用了unpark方法即使这个线程它准备睡它也不睡了

            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
