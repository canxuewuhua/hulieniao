package com.hln.algorith.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwoQueueToStack {

    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    /**
     * 使用实现类双端数组队列 ArrayDeque
     * 使用两个队列实现栈的功能 先进后出的功能
     * 1、入栈的方法push
     * 2、出栈的方法pop
     *
     * 个人理解：使用一个空的queue作为缓存地带 等另外一个queue剩下最后一个元素 将其弹出 就实现了栈的出栈思想
     * 在添加的时候 尽量向一个queue进行添加 另外一个队列保持empty
     */

    public void push(Integer element){
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(element);
            return;
        }
        if (queue1.isEmpty()){
            queue2.add(element);
            return;
        }
        if (queue2.isEmpty()){
            queue1.add(element);
            return;
        }
    }

    /**
     * 模拟栈的出栈操作
     * @return
     */
    public Integer pop(){
        if (queue1.isEmpty() && queue2.isEmpty()){
            try {
                throw new Exception("empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (queue1.isEmpty()){
            while (queue2.size() > 1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        if (queue2.isEmpty()){
            while (queue1.size() > 1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return null;
    }
}
