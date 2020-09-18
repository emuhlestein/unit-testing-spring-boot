package com.intelliviz.unittestingspringboot.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService dataServiceMock;

    @Test
    void testCalculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{10,10,10,10});
        assertEquals(40, business.calculateSumUsingDataService());
        verify(dataServiceMock).retrieveAllData();
    }

    @Test
    void testCalculateSum_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
        verify(dataServiceMock).retrieveAllData();
    }

    @Test
    void testCalculateSum_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
        verify(dataServiceMock).retrieveAllData();
    }
}