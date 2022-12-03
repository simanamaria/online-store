package com.coherentsolutions.consoleApp.storeHandler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopTest {

    @Test
    void testConstructor() {
        AbstractHandler next = (new Stop()).getNext();
        assertTrue(next instanceof Top5);
        AbstractHandler next1 = next.getNext();
        assertTrue(next1 instanceof OrderFromCart);
        assertNull(next1.getNext());
    }

    @Test
    void testHandleRequest() throws Exception {
        Stop stop = new Stop();
        stop.handleRequest("Input");
        assertTrue(stop.getNext() instanceof Top5);
    }

    @Test
    void testHandleRequest2() throws Exception {
        Stop stop = new Stop();
        stop.handleRequest((String) "stop");
        assertTrue(stop.getNext() instanceof Top5);
    }

    @Test
    void testHandleRequest3() throws Exception {
        try {
            (new Stop()).handleRequest("top");
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
            (new Stop()).handleRequest("order");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    void testHandleRequest5() throws Exception {
        try {
            (new Stop()).handleRequest(null);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }
}

