package com.hln.数据结构集合;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap继承自HashMap，它的多种操作都是建立在HashMap操作的基础上的。
 * 同HashMap不同的是，LinkedHashMap维护了一个Entry的双向链表，保证了插入的Entry中的顺序。这也是Linked的含义。
 *
 * --------------  LinkedHashMap=HashMap+双向链表 -------------------
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(1);
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");

        for (Map.Entry<String, String> m : map.entrySet()){
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }






        // 存在则返回存在值 不存在则返回默认值
        System.out.println(map.getOrDefault("k3","v4"));
    }
}
