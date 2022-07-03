package com.hln.设计模式23.结构型模式.桥接模式;

public class LapTop extends Computer {
    public LapTop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("笔记本电脑");
    }
}
