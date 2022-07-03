package com.hln;

public class RedisTest {
    public static void main(String[] args) {
        loan("10478");
    }

    public static String loan(String id){
        if ("10475".equals(id)){
            System.out.println("抢锁失败");
            return "抢锁失败";
        }else {
            try{
                System.out.println("执行业务");
                return "执行业务完成";
            }finally {
                System.out.println("del cache");
            }
        }
    }
}
