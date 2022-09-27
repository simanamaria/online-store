package com.coherentsolutions.domain;

import java.util.ArrayList;
import java.util.List;


public class Category {
    String name;
    List<Product> productList = new ArrayList<Product>();


    public Category(String name) {
        this.name = name;
}

    }