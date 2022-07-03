package com.hln.设计模式23.创建型模式.工厂模式.抽象工厂;

/**
 * 抽象产品工厂
 */
public interface IProductFactory {


    /**
     * 生产手机
     * @return
     */
    IphoneProduct iphoneProduct();

    /**
     * 生产路由器
     * @return
     */
    IRouterProduct irouterProduct();
}
