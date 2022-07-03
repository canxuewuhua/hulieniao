package com.hln.接口和抽象类;

public class Bird implements Animal{
    @Override
    public void eat() {
        System.out.println("鸟 吃东西");
    }

    @Override
    public void fly() {
        System.out.println("鸟 飞翔");
    }

    @Override
    public void fun() {
        Animal.super.fun();
        System.out.println("鸟实现类的ddd");
    }
}
