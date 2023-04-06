package ru.egor.qa.selenidetest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FindAvito {

    @Test
    void shouldSearch(){
        String avito = "avito.ru";
    open("https://www.ya.ru/");
    element(By.name("text")).setValue("avito").pressEnter().shouldHave(text(avito));

//        ElementsCollection results = elements("#search .g");
//        results.shouldHave(sizeGreaterThanOrEqual(6))
//                .first().shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
//        element(By.xpath("//div/a/h3")).click();

//        Wait().until(text("Selenide: лаконичные и стабильные UI тесты на Java"));
    }
}
