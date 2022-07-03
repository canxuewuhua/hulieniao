package com.hln.algorith.stackqueue;

import java.util.Stack;

/**
 * 两个栈实现队列的功能
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 模拟队列的入队-push 出队-pop
     *
     * 个人理解思想： 入队的时候 在栈上往栈1进行添加就可以了
     *   出队的时候 如果栈2为空的话，那么就将栈1的数据往栈2放，接着从栈2弹出即可
     *   如果栈2不为空的时候，那么从栈2弹出也即符合队列先进先出的特点
     */

    /**
     * 1、模拟队列的入队
     */
    public void push(Integer element){
        stack1.push(element);
    }

    /**
     * 2、模拟队列的出队
     */
    public Integer pop(){

        if (stack2.size()<=0){
            while (stack1.size() >0){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            try {
                throw new Exception("queue is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer head = stack2.pop();
        return head;

    }
}
