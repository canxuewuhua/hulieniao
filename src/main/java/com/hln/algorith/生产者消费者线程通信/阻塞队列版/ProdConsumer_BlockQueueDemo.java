package com.hln.algorith.生产者消费者线程通信.阻塞队列版;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdConsumer_BlockQueueDemo {

    public static class ShareData{
        private volatile boolean FLAG = true;
        private AtomicInteger atomicInteger = new AtomicInteger();
        BlockingQueue<String> blockingQueue = null;

        public ShareData(BlockingQueue<String> blockingQueue){
            this.blockingQueue = blockingQueue;
            System.out.println(blockingQueue.getClass().getName());
        }

        public void myProd() throws Exception {
            String data = null;
            boolean res;
            while (FLAG){
                data = atomicInteger.incrementAndGet() +"";
                res = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
                if (res){
                    System.out.println(Thread.currentThread().getName()+"\t 插入队列成功data:"+data);
                }else{
                    System.out.println(Thread.currentThread().getName()+"\t 插入队列失败:");
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("\t 大老板叫停了 表示生产动作结束FLAG=false");
        }

        public void myConsumer() throws Exception {
            String result=null;
            while(FLAG){
                result = blockingQueue.poll(2L,TimeUnit.SECONDS);
                if (null == result || result.equalsIgnoreCase("")){
                    FLAG = false;
                    System.out.println(Thread.currentThread().getName()+"\t 超过2秒没有取到蛋糕 消费退出");
                }
                System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
            }
        }

        public void stop(){
            this.FLAG = false;
        }

    }


    public static void main(String[] args) {
        ShareData shareData = new ShareData(new ArrayBlockingQueue<String>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try{
                shareData.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try{
                shareData.myConsumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "Consumer").start();

        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("5s time 到了 大老板main线程叫停");

        shareData.stop();
    }

}
