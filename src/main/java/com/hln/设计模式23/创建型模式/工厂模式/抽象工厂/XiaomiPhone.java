package com.hln.设计模式23.创建型模式.工厂模式.抽象工厂;

public class XiaomiPhone implements IphoneProduct{
    @Override
    public void sendSms() {
        System.out.println("xiaomi phone sms");
    }

    @Override
    public void call() {
        System.out.println("xiaomi phone call");
    }
}
