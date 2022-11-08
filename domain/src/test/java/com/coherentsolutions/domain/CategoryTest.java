package com.coherentsolutions.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Category#Category(String)}
     *   <li>{@link Category#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("Name", (new Category("Name")).getName());
    }
}

