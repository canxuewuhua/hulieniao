package com.hln.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(()->{

        },"A").start();
    }


    public void lock(){

    }
}
