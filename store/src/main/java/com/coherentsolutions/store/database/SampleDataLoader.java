package com.coherentsolutions.store.database;

import com.coherentsolutions.domain.Product;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private Faker faker;

    public SampleDataLoader(ProductRepository productRepository, Faker faker) {
        this.productRepository = productRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Product(
                        faker.number().numberBetween(1,200),
                        faker.commerce().productName(),
                        faker.number().numberBetween(1,999),
                        faker.number().numberBetween(1,100),
                        faker.internet().emailAddress()
                )).collect(Collectors.toList());

        productRepository.saveAll(products);

    }}