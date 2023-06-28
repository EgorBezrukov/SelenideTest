package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import ru.egor.qa.selenidetest.interfaces.JsonProcessor;
import ru.egor.qa.selenidetest.modelData.JksonJsonProcessor;
import ru.egor.qa.selenidetest.modelData.TestData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.*;

public class JsonSteps {
    TestData testData = new TestData();
    JsonProcessor processor = new JksonJsonProcessor();


    @BeforeStep
    public void readJson() throws IOException {
        String json = Files.readString(Paths.get("src/test/resources/application/TestData.json"));
        testData = processor.fromJson(json);
    }

    @Пусть("^(?:пользователь|он)? открывает страницу из файла \"([^\"]*)\"$")
    public void openUrlFromJson(@NotNull String value) {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        Configuration.browserPosition = "0x0";
        String baseUrl = null;
        switch (value) {
            case "UralsibBank.BaseUrl" -> baseUrl = testData.getUralsibBank().getBaseUrl();
            case "SwagLab.BaseUrl" -> baseUrl = testData.getSwagLab().getBaseUrl();
        }
        assert baseUrl != null;
        open(baseUrl);
    }

    @И("^(?:пользователь|он)? заполняет поле \"([^\"]*)\" значением из файла \"([^\"]*)\"$")
    public void fillingFieldsJsonValue(String fieldSelector, String value) {
        String valueField = null;
        switch (value) {
            case "SwagLab.Login" -> valueField = testData.getSwagLab().getLogin();
            case "SwagLab.Password" -> valueField = testData.getSwagLab().getPassword();
        }
        assert valueField != null;
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            $(fieldSelector).sendKeys(valueField);
            return;
        } if (fieldSelector.contains("//")) {
            $x(fieldSelector).sendKeys(valueField);
            return;
        }  $(By.name(fieldSelector)).sendKeys(valueField);
    }

}
