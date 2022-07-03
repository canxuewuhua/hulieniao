package com.hln.jdkproxy.cglib;

public class CGLibTest {

    /**
     * 执行cglib的方法调用
     */
    public static void main(String[] args) {
        // 创建cglib代理类
        CGLibProxy cgLibProxy = new CGLibProxy();
        // 初始化代理对象
        Fruit fruit = (Fruit)cgLibProxy.getInstance(new Fruit());
        // 执行方法
        System.out.println(fruit.eating());
    }
}
