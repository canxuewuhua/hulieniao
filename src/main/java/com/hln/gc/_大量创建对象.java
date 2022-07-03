package com.hln.gc;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class _大量创建对象 {

    @Data
    static class Person{
        private int age;
        private String name;
    }

    /**
     * https://blog.csdn.net/qq_26649391/article/details/122599519
     * 禁止在for循环内new对象定义申明变量
     * 这样的话其实是减少创建栈内存空间 因为在for循环里声明 new的话
     * 00xx--->对象1
     * 01xy--->对象2
     * 010z--->对象3
     *  如果在for循环外声明 for循环里new
     * 00xy--->对象1 对象2 对象3
     *
     * 声明就是在栈里面开辟一块空间 new就是在堆里开辟一块空间
     * 栈地址指向堆空间
     * 对象其实还是会很多 还有其他的解决办法吗？？减少创建大量对象
     */
    public static void main(String[] args) {
        testOne();
        System.out.println("==========================");
        testTwo();
    }

    /**
     * 方法执行完了 这些大量对象也被GC了
     */
    public static void testOne(){
        List<Person> list = new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            Person person = new Person();
            person.setName("zhangsanOne"+i);
            person.setAge(i);
            list.add(person);
        }

        for (Person person : list){
            System.out.println(person);
        }
    }

    public static void testTwo(){
        Person person = null;
        List<Person> list = new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            person = new Person();
            person.setName("zhangsanTwo"+i);
            person.setAge(i);
            list.add(person);
        }
        for (Person p : list){
            System.out.println(p);
        }
    }
}
