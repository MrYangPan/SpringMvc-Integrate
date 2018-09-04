package com.spring.mvc.entities;

/**
 * Created by Mr.PanYang on 2018/6/6.
 */
public class Student {
    private String[] username;
    private String password;

    public String[] getUsername() {
        return username;
    }

    public void setUsername(String[] username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
