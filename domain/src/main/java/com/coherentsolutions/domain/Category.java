package com.coherentsolutions.domain;
import java.util.List;


public class Category {
    private List<Product> productList;

    public Category(List<Product> productList){
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
