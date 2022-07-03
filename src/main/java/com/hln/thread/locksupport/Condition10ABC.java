package com.hln.thread.locksupport;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 循环打印10个ABC
 */
public class Condition10ABC {

    static class MyResource {
        private int num = 1;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        public void printA() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (num != 1) {
                        condition1.await();
                    }
                    System.out.print("A");
                    num = 2;
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void printB() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (num != 2) {
                        condition2.await();
                    }
                    System.out.print("B");
                    num = 3;
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void printC() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (num != 3) {
                        condition3.await();
                    }
                    System.out.print("C");
                    num = 1;
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        new Thread(()->{
            myResource.printA();
        }).start();
        new Thread(()->{
            myResource.printB();
        }).start();
        new Thread(()->{
            myResource.printC();
        }).start();
    }
}
