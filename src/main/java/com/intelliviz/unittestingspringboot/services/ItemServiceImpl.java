package com.intelliviz.unittestingspringboot.services;

import com.intelliviz.unittestingspringboot.data.ItemRepository;
import com.intelliviz.unittestingspringboot.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item> getAllItems() {
        List<Item> items = repository.findAll();
        for(Item item: items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return repository.findAll();
    }

    public Item getItemById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Item getItem(){
        return new Item(2, "Candy", 2, 10);
    }
}
