package com.hln.algorith.字符串;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StrTest {

    private final String UNION_LOGIN = "/h5/activity/20190521YKD-YD/index.html?subChannel=%s&inChannel=%s&recommended=%s&token=%s";
    public static void main(String[] args) {
        // String h5Url = h5Domain + String.format(UNION_LOGIN, channel, channel + "jinshan", "ykdjinshan", token);
        // String sign = Md5Utils.getMD5EncryptByUpper(salt + Md5Utils.getMD5EncryptByUpper(mobileStr) + salt);
        String[] str = {"1","2","3","4","5"};
        String s = String.join(",",str);
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        if(s.equals("")) return "";

        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);

    }
}
