package com.hln.thread.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 题目描述
 * 123456
 * ABCDEF
 * 交替打印输出 1 A 2 B 3 C 4 D 5 E 6 F
 *
 * 这里是练习了 park和unpark的使用
 * 直接使用LockSupport.park()  无参，指当前线程； LockSupport.unpark(参数是某个线程)
 */
public class LockSupportTest {

    static Thread t1 = null, t2= null;

    public static void main(String[] args) {
        String s1 = "123456";
        String s2 = "ABCDEF";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        t1 = new Thread(()->{
            for(char c : c1){
                System.out.print(c);
                LockSupport.unpark(t2);// 叫醒t2 这里注意：如果调用了unpark方法即使这个线程它准备睡它也不睡了
                LockSupport.park();// t1阻塞 当前线程阻塞
            }
        }, "t1");

        t2 = new Thread(()->{
            for(char c : c2){
                LockSupport.park(); // t2阻塞
                System.out.print(c);
                LockSupport.unpark(t1);// 叫醒t1
            }
        }, "t2");
        t1.start();
        t2.start();
    }

}
