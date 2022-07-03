package com.hln.深拷贝和浅拷贝;

public class UserCopy implements Cloneable{
    private String username;
    private String password;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCopy() {
    }

    public UserCopy(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public UserCopy clone() throws CloneNotSupportedException{
        return (UserCopy) super.clone();
    }
}
