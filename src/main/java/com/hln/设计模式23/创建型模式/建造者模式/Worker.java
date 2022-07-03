package com.hln.设计模式23.创建型模式.建造者模式;

/**
 * 具体的建造者 工人
 */
public class Worker extends Builder{

    private Product product;

    public Worker(){
        product = new Product();
    }
    @Override
    void buildA() {
        System.out.println("A");
        product.setBuildA("A");
    }

    @Override
    void buildB() {
        System.out.println("B");
        product.setBuildB("B");
    }

    @Override
    void buildC() {
        System.out.println("C");
        product.setBuildC("C");
    }

    @Override
    void buildD() {
        System.out.println("D");
        product.setBuildD("D");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
