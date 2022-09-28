package com.coherentsolutions.domain.categories;


import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;

import java.util.List;

public class BikeCategory extends Category {
    String name;

    public BikeCategory(String name, List<Product> productList){
        super(productList);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
        @Override
    public String toString() {
        return "Bike " + name + "Product list " + productList;
    }
}
