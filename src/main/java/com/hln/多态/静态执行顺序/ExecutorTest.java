package com.hln.多态.静态执行顺序;

public class ExecutorTest {

    static {
        System.out.println("this is static method");
    }

    {
        // 先执行静态方法 后执行非静态方法
        System.out.println("this is no static method");
    }

    public ExecutorTest(){
        System.out.println("this is no param method");
    }

    public ExecutorTest(int age){
        System.out.println("this is a param method "+ age);
    }

    /**
     * 父类--静态代码块
     *
     * 子类--静态代码块
     *
     * 父类--非静态代码块
     *
     * 父类--构造函数
     *
     * 子类--非静态代码块
     *
     * 子类--构造函数
     *
     * 子类--静态方法
     */
    public static void main(String[] args) {
        ExecutorTest test = new ExecutorTest();
        ExecutorTest test1 = new ExecutorTest(22);
        System.out.println("this is main method");
    }
}
