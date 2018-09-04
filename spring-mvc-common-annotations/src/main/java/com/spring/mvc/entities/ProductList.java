package com.spring.mvc.entities;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/6/1.
 */
public class ProductList {

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    private List<Product> items;


}
