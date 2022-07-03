package com.hln.设计模式23.创建型模式.工厂模式.工厂方法;

/**
 * 工厂方法设计模式
 *
 *缺点是需要创建很多的工厂 每个对象都要创建一个工厂
 * 比如说再创建一个比亚迪汽车 同样要写实体类和工厂类 虽然说没有在原来类中添加额外的代码了 但是类增加了
 *
 * 工厂方法模式在不修改已有类的前提下 通过增加新的工厂类实现扩展
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        Car car1 = new TeslaFactory().getCar();
        Car car2 = new BenzFactory().getCar();
        car1.getCarBrand();
        car2.getCarBrand();

    }
}
