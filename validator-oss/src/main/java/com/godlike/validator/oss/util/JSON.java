package com.godlike.validator.oss.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSON {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJSONString(Object o) {
        String jsonString = null;
        try {
            jsonString = OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        T t = null;
        try {
            t = OBJECT_MAPPER.readValue(text, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

}
