package com.intelliviz.unittestingspringboot.services;

import com.intelliviz.unittestingspringboot.business.SomeBusinessImpl;
import com.intelliviz.unittestingspringboot.business.SomeDataService;
import com.intelliviz.unittestingspringboot.data.ItemRepository;
import com.intelliviz.unittestingspringboot.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl service;

    @Mock
    private ItemRepository repository;

    @Test
    void testGetAllItems() {
        when(repository.findAll()).thenReturn( Arrays.asList(
                new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 20, 20)));
        List<Item> items = service.getAllItems();
        assertEquals(10*10, items.get(0).getValue());
        assertEquals(20*20, items.get(1).getValue());
    }
}