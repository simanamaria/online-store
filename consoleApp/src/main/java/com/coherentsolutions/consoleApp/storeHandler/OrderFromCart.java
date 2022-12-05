package com.coherentsolutions.consoleApp.storeHandler;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.multithreading.CartCleaner;
import com.coherentsolutions.store.multithreading.CartOrder;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

public class OrderFromCart extends AbstractHandler{
    public OrderFromCart() {
        super(null);
    }
    private static final CopyOnWriteArrayList<Product> cartOrder = new CopyOnWriteArrayList<>();
    private static void order(List<Product> allProducts){

        new Thread(new CartOrder(cartOrder, allProducts)).start();
    }
    @Override
    @Async
    public void handleRequest(String input) {
        if (input.equals("order")){
            Timer timer = new Timer();
            timer.schedule(new CartCleaner(cartOrder), 0,120000);
            List<Category> categoryList = Store.getInstance().getCategoryList();
            Category firstCategory = categoryList.get(0);
            List<Product> firstCategoryProducts = firstCategory.getProductList();
            order(firstCategoryProducts);
        } else if (getNext() != null) {
            System.out.println("Wrong Command");
        }
        }
}
