package com.hln.algorith.compareandset;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger atomicInteger = new AtomicInteger(1);
 * atomicInteger.compareAndSet(1, 2);
 *
 * 解释：compareAndSet(expect, update), 要想更新成功的话，那么这个expect的值一定是1，将被更新为2
 * 所以上面一定能更新为2  compareAndSet的返回值为true
 *
 * AtomicInteger atomicInteger = new AtomicInteger(1);
 * atomicInteger.compareAndSet(2, 3);
 * 解释：compareAndSet(expect, update), 要想更新成功的话，那么这个expect的值一定是1，但是expect为2
 * 所以上面永远无法更新为3  compareAndSet的返回值为false
 */
public class CompareAndSetTest {

    /**
     * AtomicInteger atomicInteger = new AtomicInteger(0)
     * boolean compareAndSet(int expect, int update)
     * atomicInteger.compareAndSet(expect, update)
     *
     * atomicInteger为初始值
     * expect为预期值
     * update为要更新的值
     * 初始值等于预期值能更新成功 返回true
     * 反之则更新失败 返回false
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        CompareAndSetTest test = new CompareAndSetTest();
        for (int i = 0; i < 10; i++) {
            test.getQueueAndIncrement();
        }
    }

    /**
     * 该示例为在设计 ribbon的自定义负载均衡算法的时候用到
     * 就是拿最后的执行结果next 对机器的数量取模 getQueueAndIncrement()%size 再定位index索引值
     * ！定位是用哪台机器进行返回请求的结果！
     * @return
     */
    public int getQueueAndIncrement(){
        int current = 0;
        int next = 0;
        do{
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***第几次访问，次数 "+ next);
        // 解释： while条件如果为true的话会一直循环
        //       如果为false结束循环体，因为compareAndSet第一个参数current=0，atomicInteger初始值为0，
        //       所以compareAndSet会执行更新操作，就返回了true，取反为false，就结束了循环体
        //       但是atomicInteger就随着不断的执行会一直加1
        return next;
    }
}
