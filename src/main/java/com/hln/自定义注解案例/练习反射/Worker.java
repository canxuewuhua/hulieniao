package com.hln.自定义注解案例.练习反射;

import lombok.Data;

@Data
public class Worker {

    private String name;
    private String gender;

    public Worker(){}

    public Worker(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public void work(){
        System.out.println("干活");
    }
}
