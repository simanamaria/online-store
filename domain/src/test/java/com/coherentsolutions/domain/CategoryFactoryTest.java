package com.coherentsolutions.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CategoryFactoryTest {

    @Test
    void testGetCategory() {
        Category actualCategory = (new CategoryFactory()).getCategory(CategoryEnum.BIKE);
        assertEquals(CategoryEnum.BIKE, actualCategory.getEnumName());
        assertTrue(actualCategory.getProductList().isEmpty());
    }

    @Test
    void testGetCategory2() {
        Category actualCategory = (new CategoryFactory()).getCategory(CategoryEnum.MILK);
        assertEquals(CategoryEnum.MILK, actualCategory.getEnumName());
        assertTrue(actualCategory.getProductList().isEmpty());
    }

    @Test
    void testGetCategory3() {
        Category actualCategory = (new CategoryFactory()).getCategory(CategoryEnum.PHONE);
        assertEquals(CategoryEnum.PHONE, actualCategory.getEnumName());
        assertTrue(actualCategory.getProductList().isEmpty());
    }
}

