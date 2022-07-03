package com.hln.jdkproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * cglib代理对象
 */
public class CGLibProxy implements MethodInterceptor {

    private Object target;// 目标类

    /**
     * 所以说enhancer是一个代理类
     * 而且它的superclass是目标类Fruit
     */
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置父类为实例类
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法调用前业务处理");
        Object result = methodProxy.invokeSuper(o, objects);
        return result+"代理类说很好吃";
    }
}
