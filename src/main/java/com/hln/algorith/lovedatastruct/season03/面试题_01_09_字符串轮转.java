package com.hln.algorith.lovedatastruct.season03;

public class 面试题_01_09_字符串轮转 {

    public static boolean isRevolving(String s1, String s2){
        if (s1 == null || s2==null) return false;
        if (s1.length() != s2.length()) return false;
        return (s1+s2).contains(s2);
    }
}
