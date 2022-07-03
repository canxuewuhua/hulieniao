package com.hln.多态.向上转型和向下转型;

public class DuoTaiTest {

    /**
     * https://blog.csdn.net/weixin_44706512/article/details/89413708
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 向上转型
         */
        Person stu = new Student();

        /**
         * 向下转型 强制类型转换(将父类引用转为子类引用)
         * 把父类引用转成子类引用 再向下转
         */
        Person p = new Student();
        Student student = (Student)p;
        student.speak();
        student.school();
    }
}
