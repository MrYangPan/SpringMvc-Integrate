package com.spring.mvc.dao.entity;

/**
 * Created by Mr.PanYang on 2018/5/28.
 */
public class Account {

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    private Integer id;
    private String name;
    private String money;
}
