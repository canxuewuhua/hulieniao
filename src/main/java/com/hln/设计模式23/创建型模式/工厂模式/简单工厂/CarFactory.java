package com.hln.设计模式23.创建型模式.工厂模式.简单工厂;

public class CarFactory {

    public static Car getCar(String carName){
        if (carName.equals("五菱宏光")){
            return new Wuling();
        }else if (carName.equals("特斯拉")){
            return new Tesla();
        }
        return null;
    }
}
