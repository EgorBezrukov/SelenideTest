package ru.egor.qa.selenidetest.model;

import java.util.Map;

public interface JsonProcessor {

    String toJson(TestData testData);
    TestData fromJson(String json);
    Map fromJsonAsMap(String json);

}
