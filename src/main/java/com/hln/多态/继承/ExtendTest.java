package com.hln.多态.继承;

public class ExtendTest {

    /**
     * https://blog.csdn.net/m0_51955470/article/details/120715060
     * Java继承-子类不可以继承父类的构造方法
     *
     * 如果父类没有构造方法 即一个类都会有默认的空参数的构造方法 此时子类即使不写super() 编译器也会默认一个super()
     *
     * 但是一旦父类有构造方法 继承的子类必须要写super(参数)指定要访问的父类的构造方法
     * 否则编译会报错！！！
     */

    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 12, 89);

        Person person = new Student("zhangsan", 22, 90);
        Student student = (Student) person;// 向下转型
        student.say();
        student.eat();
    }

    /**
     * ***************Java中子类能继承父类所有的数据和方法么***************
     * https://blog.csdn.net/weixin_50850749/article/details/113705826
     *
     * 1.子类可以继承父类的哪些数据域和方法
     *   子类继承它的父类中所有可访问的数据域和方法
     *   归根结底还是数据域和方法的可见性修饰符问题
     * 2.子类可以重写父类的哪些方法
     *
     */
}
