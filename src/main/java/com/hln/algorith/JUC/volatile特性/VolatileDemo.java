package com.hln.algorith.JUC.volatile特性;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    static class MyResource{

        volatile int number = 0;

        AtomicInteger atomicInteger = new AtomicInteger();

        public void addPlusPlus(){
            // volatile不能保证原子性的
            /**
             * 原因是：++操作是三步 第一步：先读取最新值 第二步：加1 第三步 写回主内存
             * 读取由于可见行肯定保证最新值 但是再进行加1 由于是多线程情况下 会覆盖值
             */
            number++;
        }

        public void addMyAtomic(){
            /**
             * 这样就能保证每次输出最终值都为20000
             * 内部实现Unsafe compareAndSwapInt
             */
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for (int i = 1; i <=20; i++) {
            new Thread(()->{
                for (int j = 1; j <=1000; j++) {
                    myResource.addPlusPlus();
                    myResource.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }
        /**
         * 2 默认值主线程+GC线程
         */
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t number: "+myResource.number);
        System.out.println(Thread.currentThread().getName()+"\t atomicInteger: "+myResource.atomicInteger);
    }
}
