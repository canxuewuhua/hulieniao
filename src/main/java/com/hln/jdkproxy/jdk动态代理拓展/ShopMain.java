package com.hln.jdkproxy.jdk动态代理拓展;

/**
 * 用户买U盘
 */

import com.hln.jdkproxy.jdk动态代理拓展.动态代理实例.UsbJDKProxy;
import com.hln.jdkproxy.jdk动态代理拓展.静态代理实例.TaoBao;

public class ShopMain {
    public static void main(String[] args) {
//        TaoBao taoBao = new TaoBao();
//        float price = taoBao.sell(1);
//        System.out.println("通过淘宝的商家， 购买U盘的单价为："+price);

        UsbJDKProxy jdkProxy = new UsbJDKProxy();
        UsbSell usbSellInstance = (UsbSell)jdkProxy.getInstance(new UsbKingFactory());
        float price = usbSellInstance.sell(1);
        System.out.println("通过动态代理后 购买U盘的单价为："+price);
    }
}
