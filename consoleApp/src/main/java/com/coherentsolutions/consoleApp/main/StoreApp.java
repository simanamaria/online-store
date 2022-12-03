package com.coherentsolutions.consoleApp.main;

import com.coherentsolutions.consoleApp.storeHandler.SortProducts;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.helper.StoreHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import static com.coherentsolutions.store.database.DatabaseApplication.*;
@SpringBootApplication
public class StoreApp {
   public static void main(String[] args) throws Exception {
       StoreHelper storeHelper = new StoreHelper(Store.getInstance());
       storeHelper.populateStore();

       SpringApplication.run(StoreApp.class, args);
       try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:product", "sa", "")) {
           createSchema(connection);
           for (int i = 1; i <= 100; ++i) {
               createProduct(connection, i);
               createCategory(connection, i);
           }
           printProducts(connection);
       }
       try {
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
           while (true) {
               System.out.println("Enter the command: top/sort/order/stop");
               String input = bufferedReader.readLine();
               new SortProducts().handleRequest(input);
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
