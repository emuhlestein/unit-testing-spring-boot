package com.intelliviz.unittestingspringboot.services;

import com.intelliviz.unittestingspringboot.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemServiceImpl implements ItemService {
    @Override
    public Item getItem(){
        return new Item(2, "Candy", 2, 10);
    }
}
