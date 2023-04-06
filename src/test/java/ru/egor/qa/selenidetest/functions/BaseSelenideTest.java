package ru.egor.qa.selenidetest.functions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

public class BaseSelenideTest {


    @BeforeEach
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 60000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }
}
