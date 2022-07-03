package com.hln.algorith.批量提交;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/**
 * 收集1000提交一次
 */
public class BatchSaveDbTest {

    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        for (int i = 1; i < 1081; i++) {
            Order order = new Order("order"+i,i);
            list.add(order);
        }
        List<List<Order>> lists= Lists.partition(list, 100);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    public static void batchInsert(List<String> recordList){
        int size = recordList.size();
        int interval = 2;
        List<String> tempList = new ArrayList<>();
        int tempFlag = 1;
        for (int i = 0; i < size; i++) {
            tempList.add(recordList.get(i));
            if ((i > 0 && i % interval == 0) || i == size - 1) {
                System.out.println("tempFlag:"+tempFlag + "\t 执行10条插入一次操作");
                // 清除临时map
                tempList.clear();
                tempFlag++;
            }
        }
        System.out.println("所有数据插入完毕");
    }
}
