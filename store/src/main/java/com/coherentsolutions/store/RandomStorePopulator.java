package com.coherentsolutions.store;
import com.coherentsolutions.domain.CategoryEnum;
import com.github.javafaker.Faker;

public class RandomStorePopulator {
    private Faker faker = new Faker();

    public String getProductName(CategoryEnum category) {
        switch (category.toString()) {
            case "BIKE":
                return faker.commerce().productName();
            case "PHONE":
                return faker.company().name();
            case "MILK":
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