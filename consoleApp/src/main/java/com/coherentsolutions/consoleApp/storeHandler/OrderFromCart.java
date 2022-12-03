package com.coherentsolutions.consoleApp.storeHandler;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.multithreading.CartCleaner;
import com.coherentsolutions.store.multithreading.CartOrder;

import java.util.List;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;


public class OrderFromCart extends AbstractHandler{
    public OrderFromCart() {
        super(null);
    }
    private static CopyOnWriteArrayList<Product> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private static void order(List<Product> allProducts){
        new Thread(new CartOrder(copyOnWriteArrayList, allProducts)).start();
    }
    @Override
    public void handleRequest(String input) {
        if (input.equals("order")){
            Timer timer = new Timer();
            timer.schedule(new CartCleaner(copyOnWriteArrayList), 0,120000);
            List<Category> categoryList = Store.getInstance().getCategoryList();
            Category firstCategory = categoryList.get(0);
            List<Product> firstCategoryProducts = firstCategory.getProductList();
            order(firstCategoryProducts);
        } else if (getNext() != null) {
            System.out.println("Wrong Command");
        }
        }
}
