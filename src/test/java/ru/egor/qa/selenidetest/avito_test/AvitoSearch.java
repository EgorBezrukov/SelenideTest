package ru.egor.qa.selenidetest.avito_test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import ru.egor.qa.selenidetest.functions.BaseSelenideTest;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

public class AvitoSearch extends BaseSelenideTest {

    /*открыть сайт https://www.avito.ru/
     * вбить в поисковую строку на главной странице "автомобил"
     * на открывшейся странице в левой части экрана из выпадающего списка выбрать категорию "автомобили"
     * на открывшейся странице выбрать категорию "audi"
     * на открывшейся странице выбрать категорию "A4"
     * Проверить что на открывшейся странице имеется 50 элементов*/
    @Test
    public void searchAuto() {
        open("https://www.avito.ru/");
        $x("//input[@type='text']").setValue("автомобили").pressEnter();
        $x("//a[@title='Автомобили']").click();
        $x("//a[@title='Audi']").click();
        $x("//a[@title='A4']").click();
        ElementsCollection results = $$x("//div[@data-marker='item']");
        results.shouldBe(sizeGreaterThanOrEqual(50));
    }

}
