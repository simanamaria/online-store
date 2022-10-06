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

    public String getProductPrice() {
        return faker.commerce().price();
    }

    public String  getProductRate() {
        return faker.commerce().promotionCode();
    }
}