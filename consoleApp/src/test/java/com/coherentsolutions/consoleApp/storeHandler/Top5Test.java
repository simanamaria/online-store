package com.coherentsolutions.consoleApp.storeHandler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Top5Test {
    @Test
    void testConstructor() {
        AbstractHandler next = (new Top5()).getNext();
        assertTrue(next instanceof OrderFromCart);
        assertNull(next.getNext());
    }

    @Test
    void testHandleRequest() throws Exception {
        Top5 top5 = new Top5();
        top5.handleRequest("Input");
        assertTrue(top5.getNext() instanceof OrderFromCart);
    }

    @Test
    void testHandleRequest2() throws Exception {
        try {
            (new Top5()).handleRequest((String) "top");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        } catch (NullPointerException e){
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    void testHandleRequest3() throws Exception {
        try {
            (new Top5()).handleRequest("top");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        } catch (NullPointerException e){
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    void testHandleRequest4() throws Exception {
        try {
            (new Top5()).handleRequest("order");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    void testHandleRequest5() throws Exception {
        try {
            (new Top5()).handleRequest(null);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }
}

