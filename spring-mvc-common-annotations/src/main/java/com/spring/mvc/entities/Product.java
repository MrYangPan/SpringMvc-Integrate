package com.spring.mvc.entities;

/**
 * Created by Mr.PanYang on 2018/6/1.
 */
public class Product {

    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "编号(id)：" + this.getId() + "，名称(name)：" + this.getName() + "，价格(price)：" + this.getPrice();
    }
}
