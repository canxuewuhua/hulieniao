package com.hln.接口和抽象类;

public class ConcreteAnimal implements Animal{

    @Override
    public void eat() {
        System.out.println("实现接口的神秘动物吃");
    }

    @Override
    public void fly() {
        System.out.println("实现接口的神秘动物飞");
    }
}
