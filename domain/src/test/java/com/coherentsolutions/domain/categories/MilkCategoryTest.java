package com.coherentsolutions.domain.categories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.coherentsolutions.domain.CategoryEnum;
import org.junit.jupiter.api.Test;

class MilkCategoryTest {

    @Test
    void testConstructor() {
        MilkCategory actualMilkCategory = new MilkCategory();
        assertEquals(CategoryEnum.MILK, actualMilkCategory.getEnumName());
        assertTrue(actualMilkCategory.getProductList().isEmpty());
    }
}

