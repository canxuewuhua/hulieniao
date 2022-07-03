package com.hln.设计模式23.创建型模式.建造者模式;

/**
 * 抽象类 建造者 定义一系列的抽象方法
 */
public abstract class Builder {

    abstract void buildA();//铺地基
    abstract void buildB();//钢筋工程
    abstract void buildC();//铺电线
    abstract void buildD();//粉刷

    /**
     * 得到具体的产品 房子 完工
     */
    abstract Product getProduct();
}
