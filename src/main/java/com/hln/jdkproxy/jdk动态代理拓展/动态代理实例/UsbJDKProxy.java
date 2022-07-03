package com.hln.jdkproxy.jdk动态代理拓展.动态代理实例;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 只需实现InvocationHandler接口的  invoke方法
 *
 * [00-规章规范]-20220302-[简历模板]- 朱永强.XXX岗位（XXX团队）-姓名-简历导入模板-20220301的副本.xlsx
 */
public class UsbJDKProxy implements InvocationHandler {
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
        float newValue = (float) result + 35.0f;
        return newValue;
    }
}
