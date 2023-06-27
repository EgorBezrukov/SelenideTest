package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.ru.Пусть;
import ru.egor.qa.selenidetest.modelData.JksonJsonProcessor;
import ru.egor.qa.selenidetest.interfaces.JsonProcessor;
import ru.egor.qa.selenidetest.modelData.TestData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.open;

public class JsonSteps {
    TestData testData = new TestData();
    JsonProcessor processor = new JksonJsonProcessor();


    @BeforeStep
    public void fromJson() throws IOException {
        String json = Files.readString(Paths.get("src/test/resources/application/TestData.json"));
        testData = processor.fromJson(json);
    }

    @Пусть("^(?:пользователь|он)? открывает страницу входа в систему ДБО$")
    public void openUrlFromJson() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        String baseUrlDBO = testData.getUralsibBank().getBaseUrl();
        open(baseUrlDBO);
    }

}
