package com.hln.jdkproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 只需实现InvocationHandler接口的  invoke方法
 */
public class JDKProxy implements InvocationHandler {
    private Object target; // 代理对象
    // 获取代理对象
    public Object getInstance(Object target){
        this.target = target;
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 执行代理方法
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args 方法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException,IllegalAccessException {
        System.out.println("动态代理之前的业务处理...");
        Object result = method.invoke(target, args);//执行调用方法 （此方法执行前后，可以进行相关业务处理）
        return result;
    }
}
