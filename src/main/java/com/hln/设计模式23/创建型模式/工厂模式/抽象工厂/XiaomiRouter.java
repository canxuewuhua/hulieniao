package com.hln.设计模式23.创建型模式.工厂模式.抽象工厂;

public class XiaomiRouter implements IRouterProduct{
    @Override
    public void open() {
        System.out.println("xiaomi router open");
    }

    @Override
    public void wifi() {
        System.out.println("xiaomi router wifi");
    }
}
