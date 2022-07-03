package com.hln.自定义注解案例.练习反射;

public class UseReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class worker1 = Worker.class;
        Class worker2 = Class.forName("com.hln.自定义注解案例.练习反射.Worker");
        Worker worker = new Worker("zhangsan","nan");
        Class worker3 = worker.getClass();
        System.out.println(worker3.newInstance());



        /**
         * 同一个类 hashcode都一样
         */
        System.out.println(worker1.hashCode());
        System.out.println(worker2.hashCode());
        System.out.println(worker3.hashCode());

        // 全限定名
        // 通过Class类信息 可以获得属性 方法 构造方法 以及注解

        System.out.println(worker3.getDeclaredMethods()[0]);
    }
}
