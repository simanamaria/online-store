package com.coherentsolutions.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void testConstructor() {
        assertEquals("Name", (new Category("Name")).getName());
    }
    
       @Test
    void testAddProduct() {
        Category category = new Category("Name");
        category.addProduct(new Product("Name", 1, 1));
        assertEquals(1, category.getProductList().size());
    }
}

