package com.coherentsolutions.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.coherentsolutions.domain.categories.BikeCategory;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void testGetProductList() {
        assertTrue((new BikeCategory()).getProductList().isEmpty());
    }

    @Test
    void testGetEnumName() {
        assertEquals(CategoryEnum.BIKE, (new BikeCategory()).getEnumName());
    }

    @Test
    void testAddProduct() {
        BikeCategory bikeCategory = new BikeCategory();
        bikeCategory.addProduct(new Product("Name", 1, 1));
        assertEquals(1, bikeCategory.getProductList().size());
    }
}

