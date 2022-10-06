package com.coherentsolutions.store;

import java.util.ArrayList;
import java.util.List;
import com.coherentsolutions.domain.Category;

public class Store {
    private List<Category> categoryList;

    public Store() {
        categoryList = new ArrayList<>();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void addCategory(Category category) {
        categoryList.add(category);

    }

    public void printCategoryProducts() {
        for (Category category : categoryList) {
            category.printProducts();
        }
    }
}