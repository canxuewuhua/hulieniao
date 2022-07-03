package com.hln.algorith;

import java.util.Scanner;

public class SwitchCaseTest {

    /**
     * 在Java7之前，switch只支持byte，short，int，char。从Java 7开始，Java中的switch也支持了String，
     * 这样在日常的编程中就可以很方便地使用switch对String进行判断，并执行不同的代码分支。
     *
     * 从代码中可以看到，支持String的switch最终还是会被转换为int类型的方式来实现
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入存款金额：");
        String m = scanner.next();
        System.out.println("请输入存款年限：");
        String y = scanner.next();
        double money = Double.valueOf(m);
        double total = getTotalAmount(money, y);
        System.out.println("总本金利息为："+total);

    }

    public static double getTotalAmount(double money, String year){
        double amount = 0d;
        switch (year){
            case "1":
                amount = money * (1+0.025d)*1;
                break;
            case "2":
                amount = money * (1+0.027d)*2;
                break;
            case "3":
                amount = money * (1+0.036d)*3;
                break;
            case "5":
                amount = money * (1+0.045d)*5;
                break;
        }
        return amount;
    }
}
