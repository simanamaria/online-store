package com.coherentsolutions.consoleApp.main;

import com.coherentsolutions.consoleApp.XML.ProductComparator;
import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.helper.StoreHelper;
import com.coherentsolutions.store.multithreading.CartOrder;
import com.coherentsolutions.store.multithreading.CartCleaner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Connection;
import java.sql.DriverManager;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.coherentsolutions.store.database.DatabaseApplication.*;
@SpringBootApplication
public class StoreApp {
    private static CopyOnWriteArrayList<Product> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
   public static void main(String[] args) throws Exception {
       SpringApplication.run(StoreApp.class, args);
        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:people","sa","")) {
            createSchema(connection);
            // create 100 rows of fake data
            for(int i = 1; i <= 100; ++i) {
                createProduct(connection, i);
                createCategory(connection, i);
            }
            printProducts(connection);
        }


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
