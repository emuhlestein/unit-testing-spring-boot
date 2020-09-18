package com.intelliviz.unittestingspringboot.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Bull\",\"price\":10,\"quantity\":100}";

    @Test
    void jsonAssert_strictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Bull\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    void jsonAssert_strictFalse() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Bull\", \"price\":10}"; //,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    void jsonAssert_withoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id: 1,name:Bull, price:10}"; //,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
