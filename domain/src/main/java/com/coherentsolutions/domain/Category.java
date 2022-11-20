package com.coherentsolutions.domain;
import java.util.ArrayList;
import java.util.List;


public abstract class Category {
    private CategoryEnum name;
    private List<Product> productList;


    public Category(CategoryEnum name) {
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public CategoryEnum getEnumName() {
        return name;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
