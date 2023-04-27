package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AfterStep {

    /*закрытие WebDriver*/
    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().quit();

    }
    /*Создание скриншота после падения теста*/

    @After
    public void onTestFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshot = Screenshots.takeScreenShotAsFile();
                InputStream targetStream = new FileInputStream(screenshot);
                Allure.addAttachment("Screenshot on fail", "image/png", targetStream, "png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
