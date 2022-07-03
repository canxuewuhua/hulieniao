package com.hln.数据结构集合;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    /**
     * LinkedList的方法
     * 1、add和push
     * 通过这两种方法均可对LinkedList进行元素添加，但不同点在于add是在链表后面添加一个元素，而push是在链表前面添加一个元素，这是添加顺序上的区别。
     *             boolean add(E e)：在链表后添加一个元素，如果成功，返回true，否则返回false；
     *             void addFirst(E e)：在链表头部插入一个元素；
     *             addLast(E e)：在链表尾部添加一个元素；
     *             void add(int index, E element)：在指定位置插入一个元素。
     *
     * 2、get方法
     *          get(int index)：按照下边获取元素；
     *          getFirst()：获取第一个元素；
     *          getLast()：获取最后一个元素；
     * 3、remove 、pop、poll移除方法
     *       remove()；移除链表中第一个元素；
     *       boolean remove(Object o)：移除链表中指定的元素；
     *       remove(int index)：移除链表中指定位置的元素；
     *       removeFirst()：移除链表中第一个元素，与remove类似；
     *       removeLast()：移除链表中最后一个元素；
     *       boolean removeFirstOccurrence(Object o)：移除链表中第一次出现所在位置的元素；
     *       boolean removeLastOccurrence(Object o)：移除链表中最后一次出现所在位置的元素；
     *
     *       pop()：与removeFirst一样，实际上它就是removeFirst；
     *       poll()：查询并移除第一个元素；
     * 4、peek获取
     *      peek()：获取第一个元素，但是不移除；
     *      peekFirst()：获取第一个元素，但是不移除；
     *      peekLast()：获取最后一个元素，但是不移除；
     * 5、offer插入方法
     *     boolean offer(E e)：在链表尾部插入一个元素；
     *     boolean offerFirst(E e)：与addFirst一样，实际上它就是addFirst；
     *     boolean offerLast(E e)：与addLast一样，实际上它就是addLast；
     * 6、其他方法
     *    contains(Object obj):判断链表中是否包含某个元素，返回值为true或false；
     *    element():获得链表的第一个元素但不删除
     *    set(int position,Object obj):将链表中第position个元素修改为obj;
     *    subList(int start,int end):取中间元素，但顾头不顾尾；
     */
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println(linkedList.peek());

        //List<String> strings = Collections.synchronizedList(linkedList);
    }
}
