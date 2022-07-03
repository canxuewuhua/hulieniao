package com.hln.jdkproxy.jdk动态代理拓展.静态代理实例;

import com.hln.jdkproxy.jdk动态代理拓展.UsbKingFactory;
import com.hln.jdkproxy.jdk动态代理拓展.UsbSell;

public class TaoBao implements UsbSell {
    private UsbKingFactory usbKingFactory = new UsbKingFactory();

    @Override
    public float sell(int amount) {
        float price = usbKingFactory.sell(amount);
        price = price + 25;
        System.out.println("这是淘宝商家 此处给你一个优惠券 或者红包");
        return price;
    }
}
