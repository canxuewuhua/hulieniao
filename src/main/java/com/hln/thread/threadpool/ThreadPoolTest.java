package com.hln.thread.threadpool;

import java.util.concurrent.*;

/**
 *  总结：
 *  CPU核数：8
 * 开始执行多线程
 * test-thread-pool:执行任务
 * test-thread-pool:执行任务
 * test-thread-pool:执行任务
 * test-thread-pool:执行任务
 * test-thread-pool:执行任务
 * main:执行任务
 * 出现了main的日志  说明我们采用的拒绝策略CallerRunsPolicy 交给了主线程进行了执行
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        System.out.println("CPU核数："+Runtime.getRuntime().availableProcessors());
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println("开始执行多线程");
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":执行任务");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("执行多线程完毕");
    }

}
