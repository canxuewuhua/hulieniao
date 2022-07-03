package com.hln.数据结构集合.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
        System.out.println(queue.add("X"));

        System.out.println("----------------------");
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(3);

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}
