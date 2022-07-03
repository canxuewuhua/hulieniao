package com.hln.intercepter;

public enum CAuthorizedType implements ICodeEnum {

    PUBLIC(1, "不需要授权"),
    LOGIN(2, "需要登陆"),
    AUTHORIZED(3, "需要显式授权,指定角色类型");

    private int code;
    private String desc;

    CAuthorizedType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return desc;
    }

}