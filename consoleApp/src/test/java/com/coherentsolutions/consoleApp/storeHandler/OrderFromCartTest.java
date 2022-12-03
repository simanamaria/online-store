package com.coherentsolutions.consoleApp.storeHandler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderFromCartTest {

    @Test
    void testConstructor() {
        assertNull((new OrderFromCart()).getNext());
    }

    @Test
    void testHandleRequest() {
        OrderFromCart orderFromCart = new OrderFromCart();
        orderFromCart.handleRequest("Input");
        assertNull(orderFromCart.getNext());
    }

    @Test
    void testHandleRequest2() {

        try {
            (new OrderFromCart()).handleRequest((String) "order");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    void testHandleRequest3() {
        try {
            (new OrderFromCart()).handleRequest("order");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    void testHandleRequest4() {
        try {
            (new OrderFromCart()).handleRequest(null);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }
    }


