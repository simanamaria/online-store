package com.coherentsolutions.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void testConstructor() {
        Product actualProduct = new Product();
        actualProduct.setId(1);
        actualProduct.setName("Name");
        actualProduct.setPrice(1);
        actualProduct.setRate(1);
        String actualToStringResult = actualProduct.toString();
        assertEquals(1, actualProduct.getId());
        assertEquals("Name", actualProduct.getName());
        assertEquals(1, actualProduct.getPrice());
        assertEquals(1, actualProduct.getRate());
        assertEquals("\nProduct name='Name', price=1, rate=1", actualToStringResult);
    }

    @Test
    void testConstructor2() {
        Product actualProduct = new Product(1, "Name", 1, 1);
        actualProduct.setId(1);
        actualProduct.setName("Name");
        actualProduct.setPrice(1);
        actualProduct.setRate(1);
        String actualToStringResult = actualProduct.toString();
        assertEquals(1, actualProduct.getId());
        assertEquals("Name", actualProduct.getName());
        assertEquals(1, actualProduct.getPrice());
        assertEquals(1, actualProduct.getRate());
        assertEquals("\nProduct name='Name', price=1, rate=1", actualToStringResult);
    }

    @Test
    void testConstructor3() {
        Product actualProduct = new Product(10, "Product Name", 10, 10, "42 Main St");
        actualProduct.setId(1);
        actualProduct.setName("Name");
        actualProduct.setPrice(1);
        actualProduct.setRate(1);
        String actualToStringResult = actualProduct.toString();
        assertEquals(1, actualProduct.getId());
        assertEquals("Name", actualProduct.getName());
        assertEquals(1, actualProduct.getPrice());
        assertEquals(1, actualProduct.getRate());
        assertEquals("\nProduct name='Name', price=1, rate=1", actualToStringResult);
    }

    @Test
    void testConstructor4() {
        Product actualProduct = new Product("Name", 1, 1);
        actualProduct.setId(1);
        actualProduct.setName("Name");
        actualProduct.setPrice(1);
        actualProduct.setRate(1);
        String actualToStringResult = actualProduct.toString();
        assertEquals(1, actualProduct.getId());
        assertEquals("Name", actualProduct.getName());
        assertEquals(1, actualProduct.getPrice());
        assertEquals(1, actualProduct.getRate());
        assertEquals("\nProduct name='Name', price=1, rate=1", actualToStringResult);
    }
}

