package ru.egor.qa.selenidetest;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.egor.qa.selenidetest.model.JksonJsonProcessor;
import ru.egor.qa.selenidetest.model.JsonProcessor;
import ru.egor.qa.selenidetest.model.TestData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@JsonIgnoreProperties
public class TestClass {
    TestData testData;
    JsonProcessor processor;


    void setup() {
        testData = new TestData();
        processor = new JksonJsonProcessor();
    }

    @Test
    public void fromJson() throws IOException {
        String json = Files.readString(Paths.get("src/test/resources/application/TestData.json"));
        TestData testData = processor.fromJson(json);
        String baseUrl = testData.getSwagLab().getBaseUrl();
    }

//    private TestData testData;
//
//    @Before
//    public void setup() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        testData = objectMapper.readValue(new File("src/test/resources/application/TestData.json"), TestData.class);
//    }
//
//    @Test
//    public void someTest() {
//        String swagLabBaseUrl = testData.getSwagLab().getBaseUrl();
//        String swagLabLogin = testData.getSwagLab().getLogin();
//        String swagLabPassword = testData.getSwagLab().getPassword();
//
//
//    }

}
