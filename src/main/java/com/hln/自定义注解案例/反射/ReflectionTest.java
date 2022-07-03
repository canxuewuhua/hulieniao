package com.hln.自定义注解案例.反射;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Filter;

/**
 * 反射
 * 允许程序在执行期借助于Reflection Api取得任何类的内部信息 并能直接操作任意对象的内部属性及方法
 *
 *
 * 正常方式： 引入需要的包类名称--》通过new实例化--》取得实例化对象
 * 反射方式： 实例化对象--》getClass方法---》取到完整的包类名称
 *
 * 反射机制提供的功能
 * 在运行时判断任意一个对象所属的类
 * 在运行时判断任意一个类所具有的成员变量和方法
 * 调用任意一个对象的成员变量和方法
 * 在运行时处理注解
 * 生成动态代理
 *
 * 优点：我们在运行时能够动态获取所属成员变量和方法
 * 缺点
 * 反射获取一个对象 比new性能要差好几十倍！！
 */
public class ReflectionTest {

    /**
     * ************** class.forName() 和classLoader区别????   ********************
     * https://baijiahao.baidu.com/s?id=1654865863100987859&wfr=spider&for=pc
     * （1）、class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，
     *      执行类中的static块。当然还可以指定是否执行静态块。
     * （2）、classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,
     *      只有在newInstance才会去执行static块
     */

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.hln.自定义注解案例.反射.ReflectionEntity");
        Class c2 = Class.forName("com.hln.自定义注解案例.反射.ReflectionEntity");
        Class c3 = Class.forName("com.hln.自定义注解案例.反射.ReflectionEntity");
        System.out.println(c1);

        // 一个类在内存中只有一个class对象
        // 一个类加载完毕后，类的整个结构都会被封装在class对象中
        // 所以下面两个hashcode是一样的
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        /**
         * class
         * Person类 Animal类
         * 张三 李四   猫 狗 鸡
         */

        getClassInfo();
    }

    /**
     * 获取class类的示例
     * a、Class clazz = Person.class
     * b、Class clazz = person.getClass();
     * c、Class clazz = Class.forName("com.demo.Person");
     */

    /**
     * ****************** 获取运行时类的完整结构*********************
     * Field Method Constructor Superclass Interface Annotation
     */

    public static void getClassInfo() throws ClassNotFoundException {
        Class c1 = Class.forName("com.hln.自定义注解案例.反射.ReflectionEntity");
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());// 获得类名
        Field[] fields = c1.getFields();// 只能找到public属性
        fields = c1.getDeclaredFields();// 可以找到全部的属性
        for(Field field : fields){
            System.out.println(field);
        }

        // 获取类的方法
        Method[] methods = c1.getMethods();//获得本类及其父类的全部的public方法
        Method[] declaredMethods = c1.getDeclaredMethods();// 只获取本类的所有方法
    }
}
