package com.coherentsolutions.store.multithreading;
import com.coherentsolutions.domain.Product;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CartOrder extends Thread{
    private CopyOnWriteArrayList<Product> purchasedItems;
    private Product orderedProduct;
    private List<Product> productList;

    public CartOrder(CopyOnWriteArrayList<Product> purchasedItems, Product orderedProduct) {
        this.purchasedItems = purchasedItems;
        this.orderedProduct = orderedProduct;
    }

    public CartOrder(CopyOnWriteArrayList<Product> purchasedItems, List<Product> allProducts) {
        this.purchasedItems = purchasedItems;
        this.productList= productList;
    }

    @Override
    public void run(){
        System.out.println("New thread: " + Thread.currentThread().getName());

        int threadTime = new Random().nextInt(30);
        try {TimeUnit.SECONDS.sleep(threadTime);
        } catch (InterruptedException e) {throw new RuntimeException(e);}

        purchasedItems.add(orderedProduct);
        System.out.println("You ordered: ");
        purchasedItems.stream().forEach(e-> System.out.println());
        }
    }


