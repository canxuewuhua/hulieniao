package com.hln.algorith.sort;

import java.util.*;

/**
 * 默认是从小到大
 * 不指定Comparator时默认为最小堆
 *
 * 通过传入自定义的Comparator函数可以实现大顶堆
 */
public class PriorityQueueTest {

    public static List<Integer> insertList(){
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.add(8);
        queue.add(10);
        queue.add(3);
        queue.add(15);
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = insertList();
        for (Integer i : list){
            System.out.println(i);
        }
    }
}
