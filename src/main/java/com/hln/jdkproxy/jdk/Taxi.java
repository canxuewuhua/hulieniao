package com.hln.jdkproxy.jdk;

public class Taxi implements Car{
    @Override
    public void running() {
        System.out.println("The taxi is running...");
    }
}
