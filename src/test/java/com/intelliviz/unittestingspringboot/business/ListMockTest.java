package com.intelliviz.unittestingspringboot.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock(List.class);

    @Test
    void test_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    void test_differenceValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    void testReturnWithParameters() {
        when(mock.get(0)).thenReturn("Ed Muhlestein");
        assertEquals("Ed Muhlestein", mock.get(0));
        assertEquals(null, mock.get(1));
        verify(mock).get(0);
        verify(mock).get(1);
    }

    @Test
    void testReturnGenericParameters() {
        when(mock.get(anyInt())).thenReturn("Ed Muhlestein");
        assertEquals("Ed Muhlestein", mock.get(0));
        assertEquals("Ed Muhlestein", mock.get(10));
        assertEquals("Ed Muhlestein", mock.get(80));
        verify(mock, times(3)).get(anyInt());
        verify(mock, never()).get(99);
        verify(mock, atLeast(3)).get(anyInt());
        verify(mock, atMost(3)).get(anyInt());
    }

    @Test
    void argumentCapturingTest() {
        mock.add("something");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("something", captor.getValue());
    }

    @Test
    void multipleArgumentCapturingTest() {
        mock.add("something1");
        mock.add("something2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("something1", allValues.get(0));
        assertEquals("something2", allValues.get(1));
    }

    @Test
    void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        arrayListMock.get(0); //null
        arrayListMock.size(); //0
        arrayListMock.add("test1");
        arrayListMock.add("test2");
        arrayListMock.size(); // still 0
        when(arrayListMock.size()).thenReturn(5);
        assertEquals(5, arrayListMock.size());
    }

    @Test
    void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
//        arrayListSpy.get(0); //null
        arrayListSpy.size(); //0
        arrayListSpy.add("test1");
        arrayListSpy.add("test2");
        arrayListSpy.size(); // still 0
        when(arrayListSpy.size()).thenReturn(5);
        assertEquals(2, arrayListSpy.size());
    }
}
