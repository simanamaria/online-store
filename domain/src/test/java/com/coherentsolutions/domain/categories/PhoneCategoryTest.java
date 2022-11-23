package com.coherentsolutions.domain.categories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.coherentsolutions.domain.CategoryEnum;
import org.junit.jupiter.api.Test;

class PhoneCategoryTest {

    @Test
    void testConstructor() {
        PhoneCategory actualPhoneCategory = new PhoneCategory();
        assertEquals(CategoryEnum.PHONE, actualPhoneCategory.getEnumName());
        assertTrue(actualPhoneCategory.getProductList().isEmpty());
    }
}

