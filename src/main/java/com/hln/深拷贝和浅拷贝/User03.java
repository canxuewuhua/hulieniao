package com.hln.深拷贝和浅拷贝;

/**
 * 让对象实现Cloneable接口 实现clone对象实现深度拷贝
 *
 * 但是这里需要注意一点是
 * 如果都是基本类型的clone是没有问题的深度拷贝
 * 如果该对象下还有对象 那就是浅拷贝 还需要在clone方法里写
 *
 * 参数多也没办法 但是字段如果是对象类型的话 就无法实现深度拷贝
 *
 *
 * 振奋tat
 * 发表一下我的拙见，欢迎指正；
 * 假设Teacher实现了Cloneable接口，里面的Student没有实现Cloneable接口的话，这两个Teacher是不相同的，但是里面的Student是相同的，所以需要对Student再度实现Cloneable接口；
 * String类比较特殊，重写了equals方法，值一样基本就是一样的，前提别new
 */
public class User03 {

    public static void main(String[] args) {
        try {
            UserCopy copy1 = new UserCopy("wangwu","345");
            UserCopy copy2 = copy1.clone();

            System.out.println("copy1="+copy1);
            System.out.println("copy2="+copy2);
            System.out.println("copy1 username="+copy1.getUsername());
            System.out.println("copy2 username="+copy2.getUsername());
            copy2.setUsername("linsf");
            System.out.println("copy1 username="+copy1.getUsername());
            System.out.println("copy2 username="+copy2.getUsername());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
