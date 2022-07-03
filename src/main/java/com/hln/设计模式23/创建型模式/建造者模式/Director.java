package com.hln.设计模式23.创建型模式.建造者模式;

/**
 * 包工头 指挥者
 */
public class Director {

    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
