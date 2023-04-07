package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Пусть;

public class BeforeStep {
    @Пусть("открываем сайт {string}")
    public void openWebSite(String url) {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 60000;
        Selenide.open(url);
    }
}
