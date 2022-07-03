package com.hln.jdkproxy.jdk;

/**
 * JDK Proxy相关示例
 * 无需引入第三方类 只需实现 invocationHandler接口
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        Car carInstance = (Car)jdkProxy.getInstance(new Taxi());
        carInstance.running();
    }
}
