package com.hln.深拷贝和浅拷贝;

/**
 * 使用构造器 new对象 实现深度拷贝
 * 但是缺点是构造方法的参数太多 维护麻烦
 */
public class User02 {

    public static void main(String[] args) {
        // 通过构造方法实现深度拷贝 是新的地址 new肯定是新的对象了
        UserCopy copy1 = new UserCopy("wangwu","345");
        UserCopy copy2 = new UserCopy("zhaoliu","123");
        System.out.println("copy1:"+copy1);
        System.out.println("copy2:"+copy2);
        copy1.setUsername("zhangsanfeng");
        copy1.setAge(20);
        System.out.println("copy1 username:"+copy1.getUsername());
        System.out.println("copy2 username:"+copy2.getUsername());
        System.out.println("copy1 age:"+copy1.getAge());
        System.out.println("copy2 age:"+copy2.getAge());
    }
}
