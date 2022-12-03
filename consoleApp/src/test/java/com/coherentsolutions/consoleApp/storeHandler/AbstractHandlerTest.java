package com.coherentsolutions.consoleApp.storeHandler;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AbstractHandlerTest {

    @Test
    void testGetNext() {
        assertNull((new OrderFromCart()).getNext());
    }
}

