package com.hln.hashmap;

import java.util.HashMap;

public class _扩容 {

    public static void main(String[] args) {
        //默认64个大小hashMap,只要数组长度>=64, 且链表 》=8时时才会转红黑树
        HashMap<Integer, String> map = new HashMap<>(64);
        map.put(0, "王二麻子 0");
        map.put(64, "王二麻子 1");
        map.put(128, "王二麻子 2");
        map.put(256, "王二麻子 3");
        map.put(512, "王二麻子 4");
        map.put(1024, "王二麻子 5");
        map.put(2048, "王二麻子 6");
        map.put(4096, "王二麻子 7");
        map.put(8192, "王二麻子 8");
        //以上步骤就会生成在第0的索引上的一个9个节点的红黑树结构
        map.remove(8192);
        map.remove(4096);
        //移除二个后此时是一个有7个节点的红黑树
        //这一步添加41个其他位置上的节点,只要不在0节点上就行,让节点总数达到 64*0.75 = 48个
        for (int i = 1; i <= 41; i++) {
            map.put(i, "张三 " + i);
        }
        //插入第49个时触发扩容,此后红黑树结构就变成链表结构了
        map.put(42, "李四");
    }
}
