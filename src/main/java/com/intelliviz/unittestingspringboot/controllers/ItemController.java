package com.intelliviz.unittestingspringboot.controllers;

import com.intelliviz.unittestingspringboot.model.Item;
import com.intelliviz.unittestingspringboot.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item")
    public Item getItemFromService() {
        return service.getItem();
    }
}
