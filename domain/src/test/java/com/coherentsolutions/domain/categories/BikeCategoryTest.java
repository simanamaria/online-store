package com.coherentsolutions.domain.categories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.coherentsolutions.domain.CategoryEnum;
import org.junit.jupiter.api.Test;

class BikeCategoryTest {

    @Test
    void testConstructor() {
        BikeCategory actualBikeCategory = new BikeCategory();
        assertEquals(CategoryEnum.BIKE, actualBikeCategory.getEnumName());
        assertTrue(actualBikeCategory.getProductList().isEmpty());
    }
}

