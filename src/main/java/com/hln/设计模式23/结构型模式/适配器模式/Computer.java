package com.hln.设计模式23.结构型模式.适配器模式;


/**
 * 适配器模式可以将原本不兼容的的类 可以在一起工作
 *
 * 场景：想上网但是网线插不了网线 需要模拟一个转接头 Adapter
 *      这里就搞一个抽象的接口转换器 因为会实现不同的转换头所以肯定需要一个接口转换器-NetToUsb
 *      它的功能就是处理请求一个行为 没有具体的实现
 *
 *
 * 传参 很多都是传入一个接口 具体的在嗲用的时候传具体的接口实现类
 */
public class Computer {

    public void net(NetToUsb adapter){
        // 上网的具体实现 找一个网线转接头
        adapter.handleOnlineRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        NetLine netLine = new NetLine();
        Adapter2 adapter = new Adapter2(netLine);

        computer.net(adapter);
    }
}
