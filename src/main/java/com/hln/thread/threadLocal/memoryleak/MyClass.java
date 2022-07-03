package com.hln.thread.threadLocal.memoryleak;

public class MyClass {

    private int id;
    private byte[] bytes = new byte[1024*1024];

    public MyClass(){

    }

    public MyClass(int id){
        this.id = id;
    }
}
