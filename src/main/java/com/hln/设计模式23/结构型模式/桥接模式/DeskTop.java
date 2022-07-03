package com.hln.设计模式23.结构型模式.桥接模式;

public class DeskTop extends Computer{
    public DeskTop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("台式机");
    }
}
