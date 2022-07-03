package com.hln.thread.三种线程阻塞唤醒;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    /**
     * 这里有两个点需要注意
     * 1、await和signal必须都是在lock 和 unlock之间 否则也会报 IllegalMonitorStateException
     * 2、如果先执行signal的话再执行await 可以先让A线程睡3秒
     *    此时的情况是A线程会一直卡在那 就是一直在那阻塞
     *
     *    其实这个和Object的wait和notify是一样的
     *    但是lock使用更灵活
     */
    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            try{
                try {
                    System.out.println(Thread.currentThread().getName()+"\t ------come in..");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t ------被唤醒");
            }finally {
                lock.unlock();
            }
        },"A").start();

        new Thread(()->{
            lock.lock();
            try{
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"\t ------发出通知");
            }finally {
                lock.unlock();
            }
        },"B").start();
    }
}
