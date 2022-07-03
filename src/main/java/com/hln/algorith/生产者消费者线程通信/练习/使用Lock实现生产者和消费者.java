package com.hln.algorith.生产者消费者线程通信.练习;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公共资源类 number数量 lock锁 increment生产方法 decrement消费方法
 */
public class 使用Lock实现生产者和消费者 {

    public static class MyResource{
        private int number = 0;
        public int MAX_VALUE = 3;
        public int MIN_VALUE = 0;
        private Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public void increment() throws Exception {
            lock.lock();
            try{
                while (number >= MAX_VALUE){
                    condition.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName()+"\t 生产后 现仓储量为number:"+number);
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public void decrement() throws Exception {
            lock.lock();
            try{
                while (number <= MIN_VALUE){
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName()+"\t 消费后 现仓储量为number:"+number);
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        new Thread(()->{
            for (int i = 0; i <= 5; i++) {
                try {
                    myResource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i <= 5; i++) {
                try {
                    myResource.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i <= 5; i++) {
                try {
                    myResource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();
        new Thread(()->{
            for (int i = 0; i <= 5; i++) {
                try {
                    myResource.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
