package com.hln.值传递和引用传递;

/**
 * B站视频
 * https://www.bilibili.com/video/BV1Kr4y127bQ?spm_id_from=333.337.search-card.all.click
 */
public class ValuePassTest {

    /**
     * 为什么说Java里面只有值传递 没有引用传递
     *
     * 基本类型是值传递  非基本类型是引用传递？？错误
     * 基本类型是值传递 非基本类型传递的是内存地址 其修改了内存地址所在的堆空间的值后，源对象也修改了
     * 所以并不是传递了源对象
     *
     */
    public static void main(String[] args) {
        // 基本数据类型
        basicArg();
        // 引用数据类型
        referenceArg();
    }

    private static void basicArg(){
        int a = 1;
        System.out.println("方法执行前 a：" + a);
        methodBasicArg(a);
        System.out.println("方法执行后 a：" + a);
    }

    public static void methodBasicArg(int a){
        a = 11;
        System.out.println("方法中 a；" + a);
    }

    public static void referenceArg(){
        Dog dog = new Dog();
        dog.setName("wangcai");
        System.out.println("方法执行前 dog.name: " + dog.getName());
        methodReferenceArg1(dog);
        System.out.println("方法执行后 dog.name: " + dog.getName());
    }

    public static void methodReferenceArg1(Dog dog){
        dog = new Dog();
        dog.setName("wangcai modify");
        System.out.println("方法中 dog.name:"+ dog.getName());
    }
}
