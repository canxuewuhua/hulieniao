package com.hln.数据结构集合;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("2","2");
        treeMap.put("1","1");
        treeMap.put("4","4");
        treeMap.put("3","3");

        for (Map.Entry<String, String> map : treeMap.entrySet()) {
            System.out.println(map.getKey()+" "+map.getValue());
        }
    }
}
