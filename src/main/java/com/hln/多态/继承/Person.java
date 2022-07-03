package com.hln.多态.继承;

public class Person {
    protected  String name;
    protected  int age;
    private String gender;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void say(){
        System.out.println("this is father say");
    }
}
