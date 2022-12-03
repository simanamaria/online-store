package com.coherentsolutions.store.helper;
import com.coherentsolutions.domain.CategoryEnum;
import com.github.javafaker.Faker;

public class RandomStorePopulator {
    private Faker faker = new Faker();

    public String getProductName(CategoryEnum category) {
        switch (category.toString()) {
            case "BIKE":
            case "PHONE":
            case "MILK":
                return faker.commerce().productName();
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