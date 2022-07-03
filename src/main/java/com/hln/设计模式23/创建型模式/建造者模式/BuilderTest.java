package com.hln.设计模式23.创建型模式.建造者模式;


/**
 *  建造者模式就是属性比较多的情况下 适合于一个具有较多零件的产品的创建过程
 *  建造者模式属于创建型模式 它提供了一种创建对象的最佳方式
 *  直接指挥 抽象的Builder 具体的Builder 生产具体的产品
 *  包工头-指挥  工人 具体的工人去实现建造  具体的产品被建造出来
 *
 */
public class BuilderTest {

    public static void main(String[] args) {

        /**
         * 包工头是入口
         */
        // 包工头
        Director director = new Director();
        // 指挥 具体的工人完成产品
        Product build = director.build(new Worker());
        System.out.println(build.toString());
    }
}
