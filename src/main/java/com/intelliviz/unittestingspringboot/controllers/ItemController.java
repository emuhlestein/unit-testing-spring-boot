package com.intelliviz.unittestingspringboot.controllers;

import com.intelliviz.unittestingspringboot.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1, "Bull", 10, 100);
    }
}
