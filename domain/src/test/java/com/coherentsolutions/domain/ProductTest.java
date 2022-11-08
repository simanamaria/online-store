package com.coherentsolutions.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void testConstructor() {
        Product actualProduct = new Product("Name", 1, 1);

        assertEquals("Name", actualProduct.getName());
        assertEquals(1, actualProduct.getPrice());
        assertEquals(1, actualProduct.getRate());
    }
}

