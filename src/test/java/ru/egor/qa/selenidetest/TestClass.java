package ru.egor.qa.selenidetest;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.egor.qa.selenidetest.modelData.JksonJsonProcessor;
import ru.egor.qa.selenidetest.interfaces.JsonProcessor;
import ru.egor.qa.selenidetest.modelData.TestData;
import ru.egor.qa.selenidetest.steps.UiCommonSteps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;


@JsonIgnoreProperties
public class TestClass extends UiCommonSteps {
    @BeforeEach
    public void configure(){
        Configuration.browser = "chrome";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
    }

    @Test
    public void testClass(){
        var url = "https://www.saucedemo.com/";
        var loginField = $(By.name("user-name"));
        var passwordField = $(By.name("password"));
        var loginButton = $(By.name("login-button"));
        open(url);
        loginField.hover();
        loginField.setValue("standard_user");
        cleanField("user-name");
        passwordField.setValue("secret_sauce");
        cleanField("password");
        loginButton.click();

    }
//    TestData testData;
//    JsonProcessor processor;
//
//
//    void setup() {
//        testData = new TestData();
//        processor = new JksonJsonProcessor();
//    }
//
//    @Test
//    public void fromJson() throws IOException {
//        String json = Files.readString(Paths.get("src/test/resources/application/TestData.json"));
//        TestData testData = processor.fromJson(json);
//        String baseUrl = testData.getSwagLab().getBaseUrl();
//    }

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
