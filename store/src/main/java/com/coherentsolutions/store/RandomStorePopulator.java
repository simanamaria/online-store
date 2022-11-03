package com.coherentsolutions.store;
import com.github.javafaker.Faker;

public class RandomStorePopulator {
    private Faker faker = new Faker();

    public String getProductName(String categoryName) {
        switch (categoryName) {
            case "Bike":
                return faker.commerce().productName();
            case "Phones":
                return faker.company().name();
            case "Milk":
                return faker.company().buzzword();
            default:
                return null;
        }
    }

    public int getProductPrice() {
        return faker.number().numberBetween(1,999);
    }

    public int  getProductRate() {
        return faker.number().numberBetween(1,100);
    }
}