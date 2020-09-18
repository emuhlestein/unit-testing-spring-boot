package com.intelliviz.unittestingspringboot.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {
    @Test
    void testCalculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{10, 10, 10, 10});
        int expectedResult = 40;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCalculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}