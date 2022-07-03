package com.hln.algorith.正则表达式;

public class Test {

    public static void main(String[] args) {
        String str = "123";
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        Character c = '2';
        System.out.println(Character.isDigit(c));
        System.out.println(Character.isLetter(c));
    }
}
