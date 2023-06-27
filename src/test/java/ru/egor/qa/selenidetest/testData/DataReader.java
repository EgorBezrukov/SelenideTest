package ru.egor.qa.selenidetest.testData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataReader {
    private TestDataClass testData;

    public static List<TestDataClass> getData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = Resources.getResource("srs/resources/application/TestData.json").openStream();
        List<TestDataClass> data = objectMapper.readValue(inputStream, new TypeReference<List<TestDataClass>>() {});
        return List.copyOf(data);
    }

//    public void setup() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        testData = objectMapper.readValue(new File("srs/resources/application/TestData.json"), TestDataClass.class);
//    }
}
