package com.hln.接口和抽象类;

public interface Animal {

    // 所有动物都会吃
    public void eat();
    // 所有动物都会飞
    public void fly();

    public default void fun(){
        System.out.println("ddd");
    }
}
