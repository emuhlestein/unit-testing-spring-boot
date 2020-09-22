package com.intelliviz.unittestingspringboot.controllers;

import com.intelliviz.unittestingspringboot.model.Item;
import com.intelliviz.unittestingspringboot.services.ItemService;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    @MockBean
    private ItemService itemService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
//        JSONAssert.assertEquals(expected, actual, strict);
    }

    @Test
    public void testGetItemFromService() throws Exception {
        when(itemService.getItem()).thenReturn(new Item(2, "Item2", 10, 10));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, name: Item2,price:10,quantity:10}"))
                .andReturn();
    }

    @Test
    public void testGetAllItems() throws Exception {
        when(itemService.getAllItems()).thenReturn(
                Arrays.asList(
            new Item(2, "Item2", 10, 10),
            new Item(3, "Item3", 20, 20)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2, name: Item2,price:10,quantity:10},{id:3, name: Item3,price:20,quantity:20}]"))
                .andReturn();
    }

    @Test
    void name() {
        String response = "[" +
            "{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5}," +
            "{\"id\":10001, \"name\":\"Pen\", \"quantity\":15}," +
            "{\"id\":10002, \"name\":\"Eraser\", \"quantity\":10}" +
         "]";

        DocumentContext context = JsonPath.parse(response);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(10000, 100001, 100002);

        context.read("$.[1]");
        context.read("$.[0:1]");
        context.read("$.[?(@.name=='Eraser')]");
        context.read("$.[?(@.quantity==5)]");

    }
}