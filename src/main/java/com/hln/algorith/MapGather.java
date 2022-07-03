package com.hln.algorith;

import java.util.HashMap;
import java.util.Map;

public class MapGather {

    public static void main(String[] args) {
        loopMap();
    }

    /**
     * 遍历map常用方法
     */
    public static void loopMap(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        for (Map.Entry<Integer,Integer> m : map.entrySet()){
            int key = m.getKey();
            int value = m.getValue();
            System.out.println("key:"+key+" value:"+value);
        }
    }
}
