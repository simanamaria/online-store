package com.coherentsolutions.store.multithreading;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.database.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
@Slf4j
public class CartOrder implements Runnable{
    private CopyOnWriteArrayList<Product> purchasedItems;
    private Product orderedProduct;
    private List<Product> productList;
    @Autowired
    private ProductRepository productRepository;

    public CartOrder(CopyOnWriteArrayList<Product> purchasedItems, Product orderedProduct) {
        this.purchasedItems = purchasedItems;
        this.orderedProduct = orderedProduct;
    }

    public CartOrder(CopyOnWriteArrayList<Product> purchasedItems, List<Product> allProducts) {
        this.purchasedItems = purchasedItems;
        this.productList= productList;
    }

    @Async
        public void run(){
        log.info("New thread: " + Thread.currentThread().getName());

        int threadTime = new Random().nextInt(30);
        try {TimeUnit.SECONDS.sleep(threadTime);} catch (InterruptedException e) {throw new RuntimeException(e);}

        purchasedItems.add(orderedProduct);
        System.out.println("You ordered: ");
        purchasedItems.forEach(System.out::println);
        }

        @Async
        public CompletableFuture<List<Product>> getAllOrderedProducts(){
        log.info("List of added products");
        final List<Product> orderedProducts = (List<Product>) productRepository.findAll();
        return CompletableFuture.completedFuture(productList);
        }
    }


