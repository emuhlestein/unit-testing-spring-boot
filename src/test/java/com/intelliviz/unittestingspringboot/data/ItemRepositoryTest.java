package com.intelliviz.unittestingspringboot.data;

import com.intelliviz.unittestingspringboot.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository repository;

    @Test
    void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

    @Test
    void testFindOneItem() {
        Item item = repository.findById(10001).get();
        assertEquals(10001, item.getId());
    }
}
