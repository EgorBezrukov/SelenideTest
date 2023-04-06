package ru.egor.qa.selenidetest.avito_test;

import org.junit.jupiter.api.Test;
import ru.egor.qa.selenidetest.functions.BaseSelenideTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AvitoLogin extends BaseSelenideTest {

    /*1.открыть avito.ru
    2.нажать на кнопку войти
    3.ввести валидный логин и пароль и нажать ентер*/

    @Test
    public void loginInAvito() {
        open("https://www.avito.ru/");
        $x("//a[text()='Вход и регистрация']").click();
        $x("//input[@name='login']")
                .setValue("")
                .pressTab();
        $x("//input[@name='password']")
                .setValue("")
                .pressEnter();
        $x("//div[@class='index-root-_NPPn header-services index-responsive-N4Ry5']")
                .shouldBe(visible);

    }
}
