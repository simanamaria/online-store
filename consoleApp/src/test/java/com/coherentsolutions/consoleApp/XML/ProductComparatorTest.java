package com.coherentsolutions.consoleApp.XML;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.coherentsolutions.domain.categories.BikeCategory;
import com.coherentsolutions.store.Store;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ProductComparatorTest {
    private Store instance = Store.getInstance();
    private ProductComparator productComparator = new ProductComparator();



        @Test
        void testProductsToSort2 () {
        try {
            (new ProductComparator()).productsToSort(null);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);

    }}

        @Test
        void testProductsToSort3 (){
            ProductComparator productComparator = new ProductComparator();
            Store store = mock(Store.class);
            when(store.getCategoryList()).thenReturn(new ArrayList<>());
            assertTrue(productComparator.productsToSort(store).isEmpty());
            verify(store).getCategoryList();
        }

        @Test
        void testSortProducts () throws Exception {
            try {
                productComparator.sortProducts(Store.getInstance());
                fail();
            }catch (RuntimeException e){
                assertTrue(e instanceof RuntimeException);
            } catch (FileNotFoundException ex){
                assertTrue(ex instanceof FileNotFoundException);
        }}

        @Test
        void testMostExpensive () {
            try {
                productComparator.mostExpensive(Store.getInstance());
                fail();
            }catch (NullPointerException e){
                assertTrue(e instanceof NullPointerException);
            } catch (IndexOutOfBoundsException ex) {
                assertTrue(ex instanceof IndexOutOfBoundsException);

        }}
        @Test
        void testMostExpensive2 () {
            try {
                (new ProductComparator()).mostExpensive(null);
                fail();
            } catch (NullPointerException ex) {
                assertTrue(ex instanceof NullPointerException);
            }}

        @Test
        void testMostExpensive3 () {
            try {
                instance.addCategory(new BikeCategory());
                productComparator.mostExpensive(instance);
                fail();
            } catch (IndexOutOfBoundsException ex) {
                assertTrue(ex instanceof IndexOutOfBoundsException);
        }}

        @Test
        void testMostExpensive4 () {
            try {
                instance.addCategory(null);
                productComparator.mostExpensive(instance);
                fail();
            } catch (NullPointerException ex) {
                assertTrue(ex instanceof NullPointerException);
        }
    }}

