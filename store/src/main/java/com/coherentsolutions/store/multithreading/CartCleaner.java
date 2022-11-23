package com.coherentsolutions.store.multithreading;

import com.coherentsolutions.domain.Product;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class CartCleaner extends TimerTask {
   private CopyOnWriteArrayList<Product> copyOnWriteArrayList;
   public CartCleaner(CopyOnWriteArrayList<Product> copyOnWriteArrayList) {
        this.copyOnWriteArrayList = copyOnWriteArrayList;
    }
    @Override
    public void run() {
        copyOnWriteArrayList.clear();
        System.out.println("Cart cleared");
    }


}
