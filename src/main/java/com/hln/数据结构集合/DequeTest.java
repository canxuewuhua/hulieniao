package com.hln.数据结构集合;

import java.util.*;
import java.util.concurrent.*;

public class DequeTest {

    public static void main(String[] args) {
        Deque deque = new LinkedList();
        Queue queue = new LinkedList<>();
        List list = new LinkedList<>();

        List arry = new ArrayList();
        LinkedList link = new LinkedList();
        ArrayList arrayList = new ArrayList();
        arrayList.lastIndexOf(4);
        Queue<Integer> pri = new PriorityQueue<>((a,b)->b-a);
        pri.offer(8);
        pri.offer(2);
        pri.offer(7);
        System.out.println(pri.peek());

        Queue blockingQueue = new LinkedBlockingQueue();

        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);
        try {
            bq.offer(1,2L,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bq.peek());;

    }
}
