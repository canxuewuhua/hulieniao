package com.hln.intercepter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface CAuthorized {

    CAuthorizedType value();

    /**
     * 授权码，用于精细的区分操作权限
     * @return
     */
    int[] roleTypes() default {};

}