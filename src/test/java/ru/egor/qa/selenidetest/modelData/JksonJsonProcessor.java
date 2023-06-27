package ru.egor.qa.selenidetest.modelData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.egor.qa.selenidetest.interfaces.JsonProcessor;

import java.util.Map;

public class JksonJsonProcessor implements JsonProcessor {
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    @Override
    public String toJson(TestData testData) {
        try {
            return objectMapper.writeValueAsString(testData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TestData fromJson(String json) {
        try {
            return objectMapper.readValue(json, TestData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map fromJsonAsMap(String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
