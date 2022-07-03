package com.hln.设计模式23.结构型模式.桥接模式;

/**
 * 抽象的电脑类型类
 */
public abstract class Computer {

    // 使用组合方式 品牌  这个就是～～桥～～
    // 想想 品牌和电脑类型没啥关系 比如台式机 平台
    // 但是可以通过DeskTop继承Computer抽象类 将品牌和台式机联系在一起

    // Computer实现了 组合 品牌和机器类型
    // 将品牌和机器类型进行联系起来
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void info(){
        // 自带品牌
        brand.info();
    }
}
