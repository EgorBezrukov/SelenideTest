package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class AfterStep {

    /*закрытие WebDriver*/
    @After
    public void tearDown(){
        WebDriverRunner.getWebDriver().quit();
        WebDriverRunner.getWebDriver().close();
    }
    /*Создание скриншота после каждого шага*/
    @io.cucumber.java.AfterStep
    public void makeScreenshot(){
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }
}
