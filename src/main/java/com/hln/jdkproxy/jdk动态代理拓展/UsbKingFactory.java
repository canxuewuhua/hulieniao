package com.hln.jdkproxy.jdk动态代理拓展;

/**
 * 商家 金士顿
 */
public class UsbKingFactory implements UsbSell{
    @Override
    public float sell(int amount) {
        System.out.println("这是目标类的方法 金士顿厂家的sell");
        return 85.0f;
    }
}
