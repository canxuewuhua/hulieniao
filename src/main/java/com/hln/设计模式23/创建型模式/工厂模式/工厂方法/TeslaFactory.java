package com.hln.设计模式23.创建型模式.工厂模式.工厂方法;

public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
