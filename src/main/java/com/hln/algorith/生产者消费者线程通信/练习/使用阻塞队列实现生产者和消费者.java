package com.hln.algorith.生产者消费者线程通信.练习;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class 使用阻塞队列实现生产者和消费者 {
    public static void main(String[] args) {

        MyResouce resouce = new MyResouce(new ArrayBlockingQueue(3));
        //生产者线程
        new Thread(()->{
            for(int i=1;i<=10;i++){
                resouce.product();
            }
        },"生产者").start();

        //消费者线程
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    resouce.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();

        try {
            TimeUnit.MILLISECONDS.sleep(10);
            resouce.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/**
 * 公共资源类
 */
class MyResouce{
    //标记 while 无限循环
    private volatile boolean FLAG = true;
    //队列中存入的数值
    private AtomicInteger atomicInteger = new AtomicInteger();
    //组合一个阻塞队列，通过构造器传入
    private BlockingQueue blockingQueue;
    public MyResouce(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    //生产者
    public void product(){
        try {
            while (FLAG){
                blockingQueue.put(String.valueOf(atomicInteger.incrementAndGet()));
                System.out.println("生产者生产第"+blockingQueue.size()+"个产品");
                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费者
    public void consumer() throws InterruptedException {
        while (FLAG){
            blockingQueue.take();
            System.out.println("消费者消费第"+(blockingQueue.size()+1)+"个产品");
        }
    }

    public void stop(){
        FLAG = false;
        System.out.println("========================");
    }
}




//public class 使用阻塞队列实现生产者和消费者 {
//
//    public static class MyResource{
//        private volatile boolean FLAG = true;
//        private AtomicInteger atomicInteger = new AtomicInteger();
//        private BlockingQueue blockingQueue;
//        public MyResource(BlockingQueue blockingQueue){
//            this.blockingQueue = blockingQueue;
//        }
//
//        public void increment() throws InterruptedException {
//            boolean offer;
//            while (FLAG){
//                String value = String.valueOf(atomicInteger.incrementAndGet());
//                offer = blockingQueue.offer(value, 2L, TimeUnit.SECONDS);
//                if (offer){
//                    System.out.println("插入队列成功，插入队列的值："+value+"当前库存："+blockingQueue.size()+"个产品");
//                }else{
//                    System.out.println("插入队列失败！当前库存："+blockingQueue.size()+"个产品");
//                }
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }
//
//        public void decrement() throws InterruptedException {
//            String result = null;
//            while (FLAG){
//                result = (String) blockingQueue.poll(2L, TimeUnit.SECONDS);
//                if (result == null || result.equalsIgnoreCase("")){
//                    FLAG = false;
//                    System.out.println("超过2秒 没有取到商品 消费退出");
//                }
//                System.out.println("消费成功 消费"+result+" 当前库存："+(blockingQueue.size())+"个产品");
//            }
//        }
//
//        public void stop(){
//            FLAG = false;
//            System.out.println("========================");
//        }
//    }
//
//    public static void main(String[] args) {
//        MyResource myResource = new MyResource(new ArrayBlockingQueue(3));
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
//            try {
//                myResource.increment();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"AA").start();
//
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
//            try {
//                myResource.decrement();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"BB").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(10);
//            myResource.stop();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
