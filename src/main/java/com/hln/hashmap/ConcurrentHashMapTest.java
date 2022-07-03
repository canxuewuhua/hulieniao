package com.hln.hashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("name1","zhangsan");
        concurrentHashMap.put("name2","lisi");
        concurrentHashMap.put("name3","wangwu");
        for (Map.Entry<String, String> map : concurrentHashMap.entrySet()){
            System.out.print(map.getKey());
            System.out.println(map.getValue());
        }
    }
}
