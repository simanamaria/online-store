package com.coherentsolutions.store;

import java.util.ArrayList;
import java.util.List;
import com.coherentsolutions.domain.Category;

public class Store {
    private List<Category> categoryList = new ArrayList<>();

    private static Store onlineStore = null;

    private Store(){};

    public static Store getInstance(){
        if (onlineStore == null) {
            onlineStore = new Store();
        }
        return onlineStore;
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