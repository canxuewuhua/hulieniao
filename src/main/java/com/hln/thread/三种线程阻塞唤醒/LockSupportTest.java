package com.hln.thread.三种线程阻塞唤醒;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    /**
     * LockSupport 随用随调 而且park和unPark也部分顺序
     *
     * 优势就是并不需要在锁块中
     *
     *
     * permit最多只有一个 重复调用unpark也不会积累凭证
     *
     * unpark就相当于是发放许可证
     * park是消耗许可证 而且许可证最多只有一个 重复调用不会积累凭证
     */
    static Thread t1 = null, t2 = null;
    public static void main(String[] args) {
        t1 = new Thread(()->{
            //try { TimeUnit.SECONDS.sleep(3L); } catch (InterruptedException e) { e.printStackTrace(); }
            // 上述代码演示是为了先执行唤醒再执行阻塞即 先执行unpark 再执行park
            //   结果是不会像之前的wait/notify await/signal阻塞在那
            //   LockSupport是不管顺序的 如果先unpark的话 那么去执行park的话 就无视park方法就行了
            System.out.println(Thread.currentThread().getName()+"\t come in.....");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"\t 被唤醒");
        },"A");

        t2 = new Thread(()->{
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName()+"\t 发出通知");
        },"B");
        t1.start();
        t2.start();


        /**
         * 总结：
         * 1、正常情况下 应该是先阻塞 unpark 再 唤醒 park 因为先唤醒再阻塞就可能一直阻塞在那了
         * 2、如果让A线程睡上3秒，也即先执行唤醒操作unpark 再执行park操作 这样应该阻塞的对吧？？ 其实不会
         *    因为unpark是发放许可证（而且是指定线程进行发放）park是消耗许可证，此时相当于无视park 其实也消耗了一个凭证
         * 3、实验多条unpark方法
         *   LockSupport.unpark(t1);
         *   LockSupport.unpark(t1);
         *   LockSupport.park();// 被阻塞
         *   LockSupport.park();// 被阻塞
         *
         *   尽管是unpark了多次但是仅仅只发放了一个许可证
         *   这样的话 就会在第二次park的时候 阻塞在那了
         *
         */
    }
}
