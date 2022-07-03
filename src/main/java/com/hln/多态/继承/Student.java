package com.hln.多态.继承;

public class Student extends Person{

    protected int score;

    public Student(String name, int age, int score){
        // 即子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
        super(name, age);
        this.score = score;
    }

    public void eat(){}

    public void say(){
        System.out.println("this is son say");
    }
}
