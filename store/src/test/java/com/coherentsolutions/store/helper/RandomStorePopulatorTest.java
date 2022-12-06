package com.coherentsolutions.store.helper;

import com.coherentsolutions.domain.CategoryEnum;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.coherentsolutions.store.helper.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class RandomStorePopulatorTest {

    @Test
    void testGetProductName() {
        assertThat( (new RandomStorePopulator()).getProductName(CategoryEnum.BIKE), matchesRegularExpression("(\\w+ ?){3,4}"));
    }

    @Test
    void testGetProductName2() {
        assertThat( (new RandomStorePopulator()).getProductName(CategoryEnum.MILK), matchesRegularExpression("(\\w+ ?){3,4}"));
    }

    @Test
    void testGetProductName3() {
        assertThat( (new RandomStorePopulator()).getProductName(CategoryEnum.PHONE), matchesRegularExpression("(\\w+ ?){3,4}"));
    }

    @Test
    void testGetProductPrice() {
        for (int i = 1; i < 1000; ++i) {
            int v = (new RandomStorePopulator()).getProductPrice();
            assertThat(v, is(lessThanOrEqualTo(1000)));
            assertThat(v, is(greaterThanOrEqualTo(0)));
        }
    }

    @Test
    void testGetProductRate() {
        for (int i = 1; i < 1000; ++i) {
            int v = (new RandomStorePopulator()).getProductRate();
            assertThat(v, is(lessThanOrEqualTo(100)));
            assertThat(v, is(greaterThanOrEqualTo(0)));
    }}
}

