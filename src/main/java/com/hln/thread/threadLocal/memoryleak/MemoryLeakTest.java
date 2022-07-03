package com.hln.thread.threadLocal.memoryleak;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MemoryLeakTest {

    /**
     * 假设-Xms25m -Xmx25m 内存大小就设置为25m
     * 该例子是一个很好的说明threadLocal发生内存泄漏的缘故的实例 切记搞明白原理
     */
    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30,30,0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), threadFactory);

        for (int i = 1; i <=30; i++) {
            threadPoolExecutor.execute(()->{
                doSomething();
                //doSomethingByList();
            });
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void doSomething(){
        ThreadLocal<MyClass> threadLocal = new ThreadLocal<>();
        try{
            MyClass myClass = new MyClass();
            threadLocal.set(myClass);
            System.out.println(Thread.currentThread().getName());
        }finally {
            // 解决内存泄露的核心  因为有线程池 即使方法执行完 也必须进行remove 因为它不会释放资源
            threadLocal.remove();
        }
    }

    /**
     * 加入使用list的话 不用考虑释放list
     * 因为list会随着方法结束 线程栈释放 里面的资源也会释放
     * 但是threadLocal不行 因为它是各个线程要去共享的 因为有线程池资源不会释放 所以这些value属于强引用不会消失 会引发内存泄漏 在内存过小的时候
     */
    public static void doSomethingByList(){
        List<MyClass> list = new ArrayList<>();
        try{
            MyClass myClass = new MyClass();
            list.add(myClass);
            System.out.println(Thread.currentThread().getName());
        }finally {
            // 解决内存泄露的核心
        }
    }
}
