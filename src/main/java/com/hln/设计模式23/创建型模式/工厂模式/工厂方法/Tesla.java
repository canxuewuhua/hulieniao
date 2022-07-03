package com.hln.设计模式23.创建型模式.工厂模式.工厂方法;

public class Tesla implements Car{
    @Override
    public void getCarBrand() {
        System.out.println("品牌：特斯拉");
    }
}
