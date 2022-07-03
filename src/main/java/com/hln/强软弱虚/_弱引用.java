package com.hln.强软弱虚;

import java.lang.ref.WeakReference;

public class _弱引用 {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;//
        System.gc();
        System.out.println("============");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
