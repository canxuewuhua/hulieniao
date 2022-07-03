package com.hln.thread;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("A thread");
        },"A");
        thread.start();

        Thread.State state = thread.getState();
    }
}
