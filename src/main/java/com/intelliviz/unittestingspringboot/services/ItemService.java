package com.intelliviz.unittestingspringboot.services;

import com.intelliviz.unittestingspringboot.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(int id);
    Item getItem();
}
