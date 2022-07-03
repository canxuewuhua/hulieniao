package com.hln.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientSpringContainer {

    /**
     * 如果scope使用的是原型prototype 会报下面的错误
     * Is there an unresolvable circular reference?
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);
    }
}

