package com.hln.algorith;

public class StringPool {

    public static void main(String[] args) {
        f1();
    }

    public static void f1(){
        String s = new String ("b") + new String("b");
        System.out.println(s);
        String s1 = s.intern();
        System.out.println(s1);
        String s2 = "bb";
        System.out.println(s == s1);
        System.out.println(s1 == s2);

    }
    public void f2(){
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc").intern();

        /**
         * true
         * false
         * true
         */
        System.out.println(s1 == s2); // 都在常量池中
        System.out.println(s1 == s3);// new是在堆里创建了一个对象
        System.out.println(s1 == s4);//优化String s4会将abc放到常量池中
    }
}
