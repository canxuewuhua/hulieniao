package com.hln.jdkproxy.jdk;

public class Bus implements Car{
    @Override
    public void running() {
        System.out.println("The bus is running...");
    }
}
