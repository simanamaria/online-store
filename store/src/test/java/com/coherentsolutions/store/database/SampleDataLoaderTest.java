package com.coherentsolutions.store.database;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.coherentsolutions.domain.Product;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import com.github.javafaker.Number;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SampleDataLoader.class})
@ExtendWith(SpringExtension.class)
class SampleDataLoaderTest {
    @MockBean
    private Faker faker;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private SampleDataLoader sampleDataLoader;

    @Test
    void testRun() throws Exception {
        when(productRepository.saveAll((Iterable<Product>) any())).thenReturn((Iterable<Product>) mock(Iterable.class));
        Number number = mock(Number.class);
        when(number.numberBetween(anyInt(), anyInt())).thenReturn(10);
        Commerce commerce = mock(Commerce.class);
        when(commerce.productName()).thenReturn("Product Name");
        Internet internet = mock(Internet.class);
        when(internet.emailAddress()).thenReturn("42 Main St");
        when(faker.internet()).thenReturn(internet);
        when(faker.commerce()).thenReturn(commerce);
        when(faker.number()).thenReturn(number);
        sampleDataLoader.run("Args");
        verify(productRepository).saveAll((Iterable<Product>) any());
        verify(faker, atLeast(1)).commerce();
        verify(faker, atLeast(1)).internet();
        verify(faker, atLeast(1)).number();
        verify(internet, atLeast(1)).emailAddress();
        verify(commerce, atLeast(1)).productName();
        verify(number, atLeast(1)).numberBetween(anyInt(), anyInt());
    }
}

