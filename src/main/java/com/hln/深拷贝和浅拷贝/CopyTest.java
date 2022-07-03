package com.hln.深拷贝和浅拷贝;

/**
 * 浅拷贝：源对象和拷贝对象引用地址是一样的
 * 深拷贝：是新的地址
 *
 * 深拷贝的几种方式
 * 1、构造方法方式
 * 2、重写clone方法
 * 3、序列化 Gson Jackson Apache Common Lang序列化
 *
 * 总结：基本数据类型是值传递 所以修改值后不会影响另一个对象的属性值
 * 引用数据类型是地址传递（引用传递） 所以修改值后另一个对象的该对象的该属性值会同步被修改
 *
 * 简单说：深拷贝对引用数据类型的成员变量的对象图中的所有对象都开辟了内存空间
 * 而浅拷贝只是传递地址指向 新的对象并没有对引用数据类型创建内存空间
 * 深拷贝之后 无论什么类型的属性值的修改 都不会影响另一个对象的属性值
 * 不过要注意的是 如果某个属性被transient修饰 那么该属性就无法被拷贝了
 */
public class CopyTest {

    public static void main(String[] args) {
        UserCopy userCopy1 = new UserCopy();
        userCopy1.setUsername("张三");
        userCopy1.setPassword("123456");
        userCopy1.setAge(15);
        UserCopy userCopy2 = userCopy1;
        System.out.println("userCopy1"+userCopy1);
        System.out.println("userCopy2"+userCopy2);
        System.out.println("1 username"+userCopy1.getUsername());
        System.out.println("2 username"+userCopy2.getUsername());
        System.out.println("1 age"+userCopy1.getAge());
        System.out.println("2 age"+userCopy2.getAge());

        userCopy2.setUsername("李四");
        userCopy2.setAge(18);
        System.out.println("1 username"+userCopy1.getUsername());
        System.out.println("2 username"+userCopy2.getUsername());
        System.out.println("1 age"+userCopy1.getAge());
        System.out.println("2 age"+userCopy2.getAge());
    }
}
