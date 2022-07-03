package com.hln.设计模式23.结构型模式.适配器模式;

/**
 * 我们再定义一个具体的转接器 同样能实现上网
 * 但是我们在这个类中使用构造器 传入参数是网线 可以上网了的功能
 */
public class Adapter2 implements NetToUsb{

    private NetLine netLine;
    public Adapter2(NetLine netLine){
        this.netLine = netLine;
    }

    @Override
    public void handleOnlineRequest() {
        netLine.request();
    }
}
