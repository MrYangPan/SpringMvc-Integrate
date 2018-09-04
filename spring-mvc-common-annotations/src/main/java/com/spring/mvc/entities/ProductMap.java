package com.spring.mvc.entities;

import java.util.Map;

/**
 * Created by Mr.PanYang on 2018/6/1.
 */
public class ProductMap {
    private Map<String, Product> items;

    public Map<String, Product> getItems() {
        return items;
    }

    public void setItems(Map<String, Product> items) {
        this.items = items;
    }
}
