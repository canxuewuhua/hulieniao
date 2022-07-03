package com.hln.设计模式23.创建型模式.工厂模式.抽象工厂;

public class XiaomiFactory implements IProductFactory{
    @Override
    public IphoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct irouterProduct() {
        return new XiaomiRouter();
    }
}
