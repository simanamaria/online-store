package com.coherentsolutions.consoleApp.main;

import com.coherentsolutions.consoleApp.storeHandler.SortProducts;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.helper.StoreHelper;
import com.coherentsolutions.consoleApp.main.server.User;
import com.coherentsolutions.consoleApp.main.server.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import static com.coherentsolutions.store.database.DatabaseApplication.*;
@SpringBootApplication
@EnableAsync
public class StoreApp implements AsyncConfigurer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StoreApp.class, args);

        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:product", "sa", "")) {
            createSchema(connection);
            for (int i = 1; i <= 100; ++i) {
                createProduct(connection, i);
                createCategory(connection, i);
            }
            printProducts(connection);
        }

        StoreHelper storeHelper = new StoreHelper(Store.getInstance());
        storeHelper.populateStore();

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

    @Bean
    CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
        return args -> {
            users.save(new User("user",encoder.encode("password"),"ROLE_USER"));
            users.save(new User("admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));
        };
    }

}