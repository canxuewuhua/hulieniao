package com.hln.签名;

import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("creditType", "0");
        //……
        paramsMap.put("openId", "20180424184601719732");
        paramsMap.put("applyNo", "APPLY2019101279272280");
        String content = paramsMap.entrySet()
                .stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining("&"));
        System.out.println(content);

    }
}
