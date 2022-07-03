package com.hln.algorith.singleton;

/**
 *  懒汉式
 *  虽然达到了按需初始化的目的 但却带来了线程不安全的问题
 */
public class Mgr05 {

    /**
     * 此处需要加上volatile  因为要防止指令重排序  -----单例模式创建对象  完结
     * 这种情况是很难复现的
     *
     * 比如说A线程因为指令重排序，只是对INSTANCE进行了半初始化，此时B线程拿到了半初始化的实力对象就有问题了
     * B线程发现已经有INSTANCE了，但是并没有初始化完该对象，就有问题了，加上volatile关键字就防止了指令重排序
     *
     * 20220423因为指令重排序 因为INSTANCE = new Mgr05();其实是三步操作
     * 1 申请空间
     * 2 初始化对象
     * 3 设置instance指向刚刚分配的地址空间
     *
     * 假如2和3顺序反过来 那么3这一步就 instance != null 但是对象还没有初始化完成
     * https://blog.csdn.net/weixin_45007916/article/details/108076954
     * 会造成线程安全问题 因为第2个线程走到第一个判空的时候就发现了不为空 但是对象还是未初始化完成 就直接返回了对象
     */

    /**
     * 这个漏洞比较tricky，很难捕捉，但是是存在的。instance = new INSTANCE();可以大致分为三步
     *
     * memory = allocate();     //1.分配内存
     * instance(memory);	    //2.初始化对象
     * instance = memory;	    //3.设置引用地址
     * 其中2、3没有数据依赖关系，可能发生重排。如果发生，此时内存已经分配，那么instance=memory不为null。
     * 如果此时线程挂起，instance(memory)还未执行，对象还未初始化。由于instance!=null，所以两次判断都跳过，最后返回的instance没有任何内容，还没初始化。
     *
     * 解决的方法就是对singletondemo对象添加上volatile关键字，禁止指令重排。
     */
    private static volatile Mgr05 INSTANCE;

    private Mgr05(){}

    /**
     * 要用的时候才去初始化 但是线程不安全 多个线程过来肯定有问题
     * 如果加上synchronized应该就没问题了吧
     * @return
     */
    public static Mgr05 getInstance(){
        if (INSTANCE == null){
            // 妄图通过减小同步代码块的方式提高效率，然后不可行

            // 比如第一个线程进来然后一直走 进行初始化
            // 假如第一个线程还没有初始化完，第二个线程进来了判断为空，此时加锁的线程一初始化完了，锁也释放了，线程二，拿到锁，又进行了一遍初始化有线程问题，引入双重检查吧
            // 双重检查锁，在synchronized里面再来一次判空，因为线程一释放了锁就等于已经初始化完了，此时INSTANCE不会为空

            // 总结：双重检查可保证对象初始化时的线程的安全
            synchronized (Mgr05.class){
                // 双重检查
                if (INSTANCE == null){
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Mgr05.getInstance().hashCode())
            ).start();
        }
    }
}
