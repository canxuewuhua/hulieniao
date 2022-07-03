package com.hln.自定义注解案例.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class _动态创建对象 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 获取Class对象
        Class c1 = Class.forName("com.hln.自定义注解案例.反射.ReflectionEntity");

        // 构造一个对象
        // 本质是调用了类的无参构造器
        ReflectionEntity reflectionEntity = (ReflectionEntity) c1.newInstance();
        System.out.println(reflectionEntity);


        /**
         * 通过构造器创建对象
         */
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        ReflectionEntity entity = (ReflectionEntity)constructor.newInstance("秦疆", 001, 18);
        System.out.println(entity);

        /**
         * 通过反射调用普通方法
         */
        ReflectionEntity entity1 = (ReflectionEntity)c1.newInstance();
        // 通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke 激活的意思
        // 对象，方法的值
        setName.invoke(entity1, "狂神");
        System.out.println(entity1.getName());

        ReflectionEntity entity2 = (ReflectionEntity)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // 下面一行设置必须在设置狂神二的前面 且设置为true 否则会报错 因为私有属性是不能访问的
        name.setAccessible(true);
        name.set(entity2, "狂神二");
        System.out.println(entity2.getName());
    }
}
