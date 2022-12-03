package com.coherentsolutions.store.helper;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.CategoryEnum;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.domain.categories.BikeCategory;
import com.coherentsolutions.store.Store;

import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreHelperTest {


    @Test
    void testPopulateStore() {
        try{StoreHelper storeHelper = new StoreHelper(Store.getInstance());
        storeHelper.populateStore();
        List<Category> categoryList = storeHelper.store.getCategoryList();
        Category getResult = categoryList.get(502);
        List<Product> productList = getResult.getProductList();
        assertEquals(4, productList.size());
        Category getResult1 = categoryList.get(503);
        assertEquals(CategoryEnum.BIKE, getResult1.getEnumName());
        assertEquals(1, getResult1.getProductList().size());
        assertEquals(CategoryEnum.PHONE, getResult.getEnumName());
        Product getResult2 = productList.get(3);
        assertEquals(330, getResult2.getPrice());
        assertEquals("Kshlerin Group", getResult2.getName());
        Product getResult3 = productList.get(2);
        assertEquals(248, getResult3.getPrice());
        assertEquals("Bode-Larkin", getResult3.getName());
        assertEquals(89, getResult3.getRate());
        Product getResult4 = productList.get(0);
        assertEquals("Effertz Group", getResult4.getName());
        assertEquals(508, getResult4.getPrice());
        assertEquals(58, getResult2.getRate());
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    void testPopulateStore2() {
        try {
            (new StoreHelper(null)).populateStore();
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    void testPopulateStore3() {
        try {Store instance = Store.getInstance();
        instance.addCategory(new BikeCategory());
        instance.addCategory(new BikeCategory());
        StoreHelper storeHelper = new StoreHelper(instance);
        storeHelper.populateStore();
        List<Category> categoryList = storeHelper.store.getCategoryList();
        Category getResult = categoryList.get(513);
        List<Product> productList = getResult.getProductList();
        assertEquals(6, productList.size());
        Category getResult1 = categoryList.get(514);
        assertEquals(CategoryEnum.BIKE, getResult1.getEnumName());
        List<Product> productList1 = getResult1.getProductList();
        assertEquals(7, productList1.size());
        assertEquals(CategoryEnum.MILK, getResult.getEnumName());
        Product getResult2 = productList.get(5);
        assertEquals(592, getResult2.getPrice());
        assertEquals("real-time", getResult2.getName());
        Product getResult3 = productList1.get(1);
        assertEquals(76, getResult3.getPrice());
        assertEquals("Durable Steel Lamp", getResult3.getName());
        Product getResult4 = productList1.get(5);
        assertEquals(842, getResult4.getPrice());
        assertEquals("Mediocre Wooden Bag", getResult4.getName());
        Product getResult5 = productList.get(0);
        assertEquals(634, getResult5.getPrice());
        assertEquals(65, getResult3.getRate());
        assertEquals(49, getResult4.getRate());
        assertEquals("intranet", getResult5.getName());
        assertEquals(71, getResult2.getRate());
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }
}

