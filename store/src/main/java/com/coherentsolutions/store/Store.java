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
}
