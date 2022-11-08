package com.coherentsolutions.domain.categories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BikeCategoryTest {

    @Test
    void testConstructor() {
        BikeCategory actualBikeCategory = new BikeCategory();
        assertEquals("Bike", actualBikeCategory.getName());
        assertTrue(actualBikeCategory.getProductList().isEmpty());
    }
}

