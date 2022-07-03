package com.hln.数据结构集合;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 多面的LinkedList：可作队列，栈，双端队列
 */
public class DequeLinkedListTest {

    /**
     * LinkedList.poll():
     * 检索并删除此列表的头部（第一个元素）。
     *
     * LinkedList.pollFirst():
     * 检索并删除此列表的第一个元素，如果此列表为空，则返回null。
     *
     * LinkedList.pollLast():
     * 检索并删除此列表的最后一个元素，如果此列表为空，则返回null。
     *
     * pop() 方法等价于removeFirst(), 底层调用的是removeFirst()方法。
     * poll()方法等价于pollFirst() 方法，底层调用的是pollFirst()。
     * 两个方法的区别在于如果deque是空的(Empty) poll方法会返回null， pop方法会抛出异常NoSuchElementException()。这也是removeFirst(), pollFirst()方法的区别。
     * 实际上，removeFirst底层调用的也是pollFirst方法，只是增加了一个null的判断。
     *
     */

    /**
     *         Deque deque = new LinkedList();
     *         Queue queue = new LinkedList<>();
     *         List list = new LinkedList<>();
     *
     *         Deque既可以做栈《先进后出》 又可以做队列《先进先出》
     *
     *         引出 LinkedHashMap=HashMap+双向链表  做缓存记录先后顺序
     */
    public static void main(String[] args) {
        Queue qu = new LinkedList<>();
        qu.add(3);
        qu.remove();

        // 实现队列 模拟队列就是先进先出 那么进就是addLast
        Deque<Integer > queue = new LinkedList<>();
//        queue.addLast(3);
//        queue.addLast(4);
//        queue.addLast(5);
        queue.add(3);
        queue.add(4);
        queue.add(5);

//        System.out.println(queue.removeFirst());
//        System.out.println(queue.removeFirst());
//        System.out.println(queue.removeFirst());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());


        // LinkedList实现栈
        // Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。Deque堆栈操作方法：push()、pop()、peek()。
        Deque<Integer > stack = new LinkedList<>();
//        stack.addFirst(8);
//        stack.addFirst(9);
//        stack.addFirst(10);
        stack.push(8);
        stack.push(9);
        stack.push(10);

//        System.out.println(stack.removeFirst());
//        System.out.println(stack.removeFirst());
//        System.out.println(stack.removeFirst());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
