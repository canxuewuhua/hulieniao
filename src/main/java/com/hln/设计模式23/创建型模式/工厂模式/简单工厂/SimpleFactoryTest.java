package com.hln.设计模式23.创建型模式.工厂模式.简单工厂;

/**
 * 原来的就是用那个就要new一个对象
 * 所以就引入了工厂模式 从工厂里面拿对象
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
//        Car car = new Wuling();
//        Car car2 = new Tesla();
//        car.name();
//        car2.name();

        /**
         * 这种方式的缺点 有新增要增加代码
         * 上面的方法和下面的方法都是静态工厂模式 或者叫做简单工厂模式 但是不符合接口设计的开闭原则
         */
        Car car1 = CarFactory.getCar("五菱宏光");
        Car car2 = CarFactory.getCar("特斯拉");
        car1.name();
        car2.name();
    }
}
