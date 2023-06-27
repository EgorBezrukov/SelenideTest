package ru.egor.qa.selenidetest.interfaces;

import ru.egor.qa.selenidetest.modelData.TestData;

import java.util.Map;

public interface JsonProcessor {

    String toJson(TestData testData);
    TestData fromJson(String json);
    Map fromJsonAsMap(String json);

}
