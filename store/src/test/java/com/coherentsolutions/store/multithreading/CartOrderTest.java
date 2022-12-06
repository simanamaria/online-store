package com.coherentsolutions.store.multithreading;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.database.ProductRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class CartOrderTest {
    @MockBean
    private CartOrder cartOrder;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void testGetAllOrderedProducts() {
        CompletableFuture<List<Product>> completableFuture = new CompletableFuture<>();
        when(cartOrder.getAllOrderedProducts()).thenReturn(completableFuture);
        assertSame(completableFuture, cartOrder.getAllOrderedProducts());
        verify(cartOrder).getAllOrderedProducts();
    }
}

