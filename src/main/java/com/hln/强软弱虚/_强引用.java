package com.hln.强软弱虚;

public class _强引用 {

    public static void main(String[] args) {
        /**
         * object1和object2都在局部变量表中指向同一个堆空间的实例对象
         */
        Object object1 = new Object();
        Object object2 = object1;
        object1 = null;// 置空
        System.gc();
        System.out.println(object2);//强引用不会被回收
    }
}
