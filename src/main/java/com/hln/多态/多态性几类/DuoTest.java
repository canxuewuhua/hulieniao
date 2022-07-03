package com.hln.多态.多态性几类;

public class DuoTest {

    public static void main(String[] args) {
        Figure figure; // 声明Figure类的变量
        figure = new Rectangle(9, 9);
        System.out.println(figure.area());
        System.out.println("===============================");
        figure = new Triangle(6, 8);
        System.out.println(figure.area());
        figure.print();
        System.out.println("===============================");
        figure = new Figure(10, 10);
        System.out.println(figure.area());



        /**
         * 这里就是把父类引用转成子类引用，具有一定的局限性。有可能出现转换异常，
         * 这时需要instanceof来判断是否是某个类的实例，
         * 如果是，返回true，这时再向下转型就比较安全了。
         *
         * 向下转型 强制类型转换(将父类引用转为子类引用)
         */
        Figure parent = new Triangle(20,20);
        if (parent instanceof Triangle) {
            Triangle triangle = (Triangle)parent;
            System.out.println(triangle.area());
        }


    }
}
