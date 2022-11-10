package com.coherentsolutions.domain.categories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MilkCategoryTest {

    @Test
    void testConstructor() {
        MilkCategory actualMilkCategory = new MilkCategory();
        assertEquals("Milk", actualMilkCategory.getName());
        assertTrue(actualMilkCategory.getProductList().isEmpty());
    }
}

