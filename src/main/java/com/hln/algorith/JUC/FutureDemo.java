package com.hln.algorith.JUC;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * https://www.jianshu.com/p/fb5dcdd3372d
 * 1、调用分页查询接口，每次最多返回100条数据，并返回该次查询的总数据条数;
 * 2、请求数据量为1000条，单线程情况下需要循环调用10次接口，然后将10次获取到的数据依次存入一个List中;
 */
public class FutureDemo {

    // 开启线程-方法1
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    // 开启线程-方法2
    // ExecutorService executorService = Executors.newCachedThreadPool();
    // 开启线程-方法3
    // ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        System.out.println(handleBusiness());
    }

    public static List<Object> handleBusiness(){
        // count:需要循环的次数
       // 查询数据方法：List<Object> dateCellList = queryDate(Object params);
        List<Object> dataAllList = new LinkedList();
        List<Future> futureList = Collections.synchronizedList(new LinkedList<>());
        int count = 10;
        for (int i = 1; i <= count; i++) {
            final Future<List<Object>> futureCell = threadPoolExecutor.submit(() -> {
                // 调用分页查询sql接口
                List<Object> dateCellList = Arrays.asList("1","2","3","4","5","6","7","8","9","10");
                return dateCellList;
            });
            futureList.add(futureCell);
        }
        for (Future future : futureList) {
            try {
                List<Object> dateCellList = (List<Object>) future.get(30, TimeUnit.SECONDS);
                dataAllList.add(dateCellList);
//                dateCellList.clear();
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        return dataAllList;
    }
}
