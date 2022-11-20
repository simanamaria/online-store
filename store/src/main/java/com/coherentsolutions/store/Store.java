package com.coherentsolutions.store;

import java.util.ArrayList;
import java.util.List;
import com.coherentsolutions.domain.Category;

public class Store {
    private List<Category> categoryList = new ArrayList<>();
    private static volatile Store instance;
    private static Object mutex = new Object();

    private Store(){};

    public static Store getInstance(){
        Store result = instance;
        if (result == null) {
            synchronized (mutex){
                result = instance;
                if (result == null) instance = result = new Store();
            }
        }
        return result;
    }
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void addCategory(Category category) {
        categoryList.add(category);

    }
}