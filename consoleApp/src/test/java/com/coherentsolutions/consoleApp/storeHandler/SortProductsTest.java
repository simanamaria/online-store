package com.coherentsolutions.consoleApp.storeHandler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SortProductsTest {

    @Test
    void testConstructor() {
        AbstractHandler next = (new SortProducts()).getNext();
        assertTrue(next instanceof Stop);
        AbstractHandler next1 = next.getNext();
        assertTrue(next1 instanceof Top5);
        AbstractHandler next2 = next1.getNext();
        assertTrue(next2 instanceof OrderFromCart);
        assertNull(next2.getNext());
    }

    @Test
    void testHandleRequest() throws Exception {
        SortProducts sortProducts = new SortProducts();
        sortProducts.handleRequest("Input");
        assertTrue(sortProducts.getNext() instanceof Stop);
    }

    @Test
    void testHandleRequest2() throws Exception {
        try {
            (new SortProducts()).handleRequest((String) "sort");
            fail();
        } catch (RuntimeException ex) {
            assertTrue(ex instanceof RuntimeException);
        } catch (FileNotFoundException e){
            assertTrue(e instanceof FileNotFoundException);
    }
    }

    @Test
    void testHandleRequest3() throws Exception {
        try {
            (new SortProducts()).handleRequest("sort");
            fail();
        } catch (RuntimeException ex) {
            assertTrue(ex instanceof RuntimeException);
        } catch (FileNotFoundException e){
            assertTrue(e instanceof FileNotFoundException);
    }
    }

    @Test
    void testHandleRequest4() throws Exception {
        SortProducts sortProducts = new SortProducts();
        sortProducts.handleRequest("stop");
        assertTrue(sortProducts.getNext() instanceof Stop);
    }

    @Test
    void testHandleRequest5() throws Exception {
        try {
            (new SortProducts()).handleRequest("top");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        } catch (NullPointerException e){
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    void testHandleRequest6() throws Exception {
        try {
            (new SortProducts()).handleRequest("order");
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    void testHandleRequest7() throws Exception {
        try {
            (new SortProducts()).handleRequest(null);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }
    }


