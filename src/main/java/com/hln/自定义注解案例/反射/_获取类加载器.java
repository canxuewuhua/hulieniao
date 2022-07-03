package com.hln.自定义注解案例.反射;

public class _获取类加载器 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器--》扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类加载器--》根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);


        //测试当前类是哪个类加载器加载的
        ClassLoader classLoader = Class.forName("com.hln.自定义注解案例.反射._获取类加载器").getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        /**
         * 注意：（引导类）启动类加载器不能直接获取！！！
         * 自定义加载器
         */
    }
}
