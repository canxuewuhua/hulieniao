package com.hln.thread.threadLocal.traceIduse;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 关于全链路追踪traceId遇到线程池的问题，做过架构的估计都遇到过，现在以写个demo，总体思想就是获取父线程traceId,给子线程，子线程用完移除掉。
 */
public class TraceTest {

    //线程池大小设置为一，保证是同一个线程run之前获取traceId，run后删除，便于测试
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {

        String traceId = UUID.randomUUID().toString().replace("-", "");
        ThreadPoolTracing.threadLocalTraceId.set(traceId);
        System.out.println("父线程={"+Thread.currentThread().getName()+"}；traceId={"+traceId+"}");

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                //ThreadLocal 拿不到值；如果是InheritableThreadLocal，可以拿到值
                String id0 = ThreadPoolTracing.threadLocalTraceId.get();
                System.out.println("子线程={"+Thread.currentThread().getName()+"},traceId={"+id0+"}");
            }
        };
        executorService.execute(runnable);//结果为空
        executorService.execute(new ThreadPoolTracing.Task());//结果为空

        Runnable wrap=  wrap( runnable);
        executorService.execute(wrap);//可以获取traceId
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        traceId = UUID.randomUUID().toString().replace("-", "");
        //traceId 重新复制
        ThreadPoolTracing.threadLocalTraceId.set(traceId);
        System.out.println("父线程={"+Thread.currentThread().getName()+"}；traceId={"+traceId+"}");
        //线程池中的traceId跟着变更
        wrap=  wrap( runnable);
        executorService.execute(wrap);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Runnable wrap(Runnable task) {
        //获取父线程中的Trace
        String id0 = ThreadPoolTracing.threadLocalTraceId.get();
        class CurrentTraceContextRunnable implements Runnable {
            @Override
            public void run() {
                //traceId 给子线程
                ThreadPoolTracing.threadLocalTraceId.set(id0);
                task.run();
                //子线程用完删除
                ThreadPoolTracing.threadLocalTraceId.remove();
            }
        }
        return new CurrentTraceContextRunnable();

    }
}
