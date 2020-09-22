package com.intelliviz.unittestingspringboot.data;

import com.intelliviz.unittestingspringboot.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
