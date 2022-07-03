package com.hln.设计模式23.创建型模式.工厂模式.抽象工厂;

/**
 * 抽象工程模式 不可以增加产品 可以增加产品族
 * 产品族 小米手机 小米路由器
 *       华为手机  华为路由器
 *      产品等级 不同产品
 *
 *      该模式下围绕一个超级工厂创建其他工厂 该超级工厂又被称为其他工厂的工厂
 *
 *      比如小米 华为
 *      核心是写一个IProductFactory
 *
 *      劣势：
 *      新增其他类后 依然要写很多的实体类和接口
 *      只不过整体将一个系列的产品统一到一起创建
 *      具体产品在应用层的代码隔离无需关心创建的细节
 *
 *      缺点 规定了所有可能被创建的产品集合 产品族中扩展新的产品困难
 *      增加了系统高德抽象性和理解难度
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        System.out.println("小米系列产品");
        IProductFactory xiaomiFactory = new XiaomiFactory();
        IphoneProduct iphoneProduct = xiaomiFactory.iphoneProduct();
        iphoneProduct.call();
        iphoneProduct.sendSms();

        IRouterProduct iRouterProduct = xiaomiFactory.irouterProduct();
        iRouterProduct.open();;
        iRouterProduct.wifi();
    }
}
