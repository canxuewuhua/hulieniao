package com.hln.自定义注解案例.反射;

/**
 * Java中静态方法、非静态方法、构造方法执行顺序
 * https://blog.csdn.net/qq_43477676/article/details/115041433
 * 核心：静态方法是在类被jvm加载的时候就会被执行，非静态方法属于对象，
 * 是在对象被创建时会被优先加载，构造方法是在对象被创建后，非静态方法之后被调用
 */
public class _静态类和方法执行过程 {

    /**
     * 执行结果为：
     * A类静态代码块初始化
     * A类的无参构造初始化
     * 100
     *
     *
     * 总结：先执行静态代码块 创建对象时执行非静态方法 对象被创建后 执行构造方法
     */
    public static void main(String[] args) {
        A a  = new A();
        System.out.println(a.m);


        /**
         * 主动引用 父类会被加载
         * 反射也会产生主动引用
         *
         * 不会产生类的引用的方法 Son.b
         * Son[] array = new Son[5];
         * Son.M M是静态常量
         */
    }
}
class A{
    static int m = 100;
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }


    public A(){
        System.out.println("A类的无参构造初始化");
    }
}
