package com.hln.设计模式23.结构型模式.适配器模式;

public class Adapter extends NetLine implements NetToUsb{


    @Override
    public void handleOnlineRequest() {
        // 这里直接调用NetLine这个抽象类
        super.request();
    }
}
