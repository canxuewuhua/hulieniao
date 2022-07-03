package com.hln.algorith.生产者消费者线程通信.传统版;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目 一个初始值为零的变量 两个线程对其交替操作 一个加1一个减1 来5轮
 * 1。线程 操作 资源类
 * 2。判断 干活 通知
 * 3。防止虚假唤醒用while
 */
public class ProdConsumer_TraditionDemo {

    /**
     * 资源类
     */
    public static class ShareData{
        private int number = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment() throws InterruptedException {
            lock.lock();
            try{
                //1. 判断
                while(number !=0){
                    // 不等于0 等待 不能生产
                    condition.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName()+"\t"+number);
                // 通知唤醒
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public void decrement() throws InterruptedException {
            lock.lock();
            try{
                //1. 判断
                while(number ==0){
                    // 等于0 等待 不能消费
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName()+"\t"+number);
                // 通知唤醒
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        // 生成两个线程  去操作资源类
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try{
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try{
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
