package com.hln.algorith.JUC;

import java.util.concurrent.*;

/**
 * https://blog.csdn.net/sx1119183530/article/details/79735348
 * Future 和 FutureTask的区别
 *
 * 在Thread中的构造函数是没有callable接口的参数的 只有runnable接口参数
 * 也就是说FutureTask的构造函数中可以是Callable接口
 *
 * https://www.cnblogs.com/Evil-Rebe/p/5916473.html
 * Future 和 FutureTask的区别案例
 */
public class FutureTaskDemo {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public static class MyThread1 implements Runnable{
        @Override
        public void run() {
        }
    }

    public static class MyThread2 implements Callable{
        @Override
        public Object call() throws Exception {
            System.out.println(Thread.currentThread().getName()+"\t come in call");
            return 200;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Runnable接口实现创建线程
        new Thread(new MyThread1(), "aa").start();
        // Callable接口实现创建线程 下面会报错 Thread构造函数中没有callable接口的实现 所以需要使用FutureTask中间类实现
        //new Thread(new MyThread2(), "aa").start();

        // 延伸 使用Future
        // threadPoolExecutor.execute(new MyThread1()); 此处execute方法是没有返回值的所以MyThread2不可以作为参数
        //Future<Integer> future = threadPoolExecutor.submit(new MyThread2()); //  Future是接口 FutureTask实现了Future

        // 一般都是通过FutureTask的方式去实现线程的并行执行
        // 这样就可以使用了callable接口了
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread2());

        FutureTask<Integer> futureTask2 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in callable");
            return 1024;
        });

        // FutureTask原理 未来任务
        // 4个同学 1同学 1加到9 2同学10加到50 3同学从51加到80
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        // 除了上面的使用 也可以使用线程池去启动
        //threadPoolExecutor.execute(futureTask2);


        while (!futureTask2.isDone()){
            System.out.println("wait");
        }

        System.out.println(futureTask2.get());
        System.out.println(Thread.currentThread().getName()+"\t come over");

    }
}
