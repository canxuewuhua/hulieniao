package com.hln.thread.三种线程阻塞唤醒;


/**
 *  三种方式
 *  synchronized(wait notify)
 *  lock(await signal)
 *  lockSupport(park unPark)
 */
public class WaitNotifyTest {

    static Object objectLock = new Object();

    /**
     * 这里有两个点需要注意
     * 1、wait和notify必须都是在synchronized代码块中 否则会报 IllegalMonitorStateException
     * 2、如果先执行notify的话再执行wait 可以先让A线程睡3秒
     *    此时的情况是A线程会一直卡在那 就是一直在那阻塞
     */
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (objectLock){
                // TimeUnit.MILLISECONDS.sleep(3); 测试先notify再wait 这样会一直阻塞
                System.out.println(Thread.currentThread().getName()+"\t ----come in");
                try{
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t -------被唤醒");
            }
        }, "A").start();
        new Thread(()->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName()+"\t ----通知");
                objectLock.notify();
            }
        }, "B").start();
    }
}
