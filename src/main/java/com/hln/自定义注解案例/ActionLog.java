package com.hln.自定义注解案例;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作日志注解
 *
 * @Filename: ActionLog.java
 * @Author: zhangshuai
 * <li>Version: 1.0</li>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionLog {

    /**
     * 业务模块名称
     *
     * @return
     */
    String module();

    /**
     * 操作名称
     *
     * @return
     */
    String action();

    /**
     * 控制器出现异常的时候返回消息
     * 此时会打印错误日志
     *
     * @return
     */
    String error() default "操作失败";

}
