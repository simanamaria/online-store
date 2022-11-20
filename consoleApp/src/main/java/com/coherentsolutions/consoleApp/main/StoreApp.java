package com.coherentsolutions.consoleApp.main;

import com.coherentsolutions.consoleApp.XML.ProductComparator;
import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.helper.StoreHelper;
import com.coherentsolutions.store.multithreading.CartOrder;
import com.coherentsolutions.store.multithreading.CartCleaner;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class StoreApp {
    private static CopyOnWriteArrayList<Product> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws Exception {
        Store onlineStore = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        storeHelper.populateStore();
        Scanner scanner = new Scanner(System.in);
        ProductComparator comparator = new ProductComparator();
        List<Category> categoryList = Store.getInstance().getCategoryList();
        Category firstCategory = categoryList.get(0);
        List<Product> firstCategoryProducts = firstCategory.getProductList();

        Timer timer = new Timer();
        timer.schedule(new CartCleaner(copyOnWriteArrayList), 0,120000);
        System.out.println("Please enter sort / order / top / stop");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equalsIgnoreCase("stop")) {
                timer.cancel();
            }
            if (next.equalsIgnoreCase("order")) {
                order(firstCategoryProducts);
            }
            if (next.equalsIgnoreCase("sort")) {
                comparator.sortProducts(onlineStore);
            }
            if (next.equalsIgnoreCase("top")) {
                comparator.mostExpensive(onlineStore);
            }}
    }
    private static void order(List<Product> allProducts){
        new Thread(new CartOrder(copyOnWriteArrayList, allProducts)).start();
    }
}
