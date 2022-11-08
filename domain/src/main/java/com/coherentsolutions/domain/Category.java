package com.coherentsolutions.domain;
import java.util.ArrayList;
import java.util.List;


public class Category {
    private String name;
    private List<Product> productList;

    public Category(String name) {
        this.name = name;
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
