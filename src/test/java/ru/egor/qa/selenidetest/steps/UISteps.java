package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class UISteps {

    @И("^(?:пользователь|он)? вводит в поле \"([^\"]*)\" знчение \"([^\"]*)\"$")
    public void input(String fieldName, String fieldValue) {
        String name;
        if (fieldName.equals("Логин")) name = "user-name";
        else name = "password";
        Selenide.$(By.name(name)).sendKeys(fieldValue);
    }
    @И("^(?:пользователь|он)? нажимает на \"([^\"]*)\"$")
    public void clickButton(String btnName) {
        Selenide.$(By.name(btnName)).click();
    }
    @Тогда("^(?:пользователь|он)? проверяет что адрес сайта равен \"([^\"]*)\"$")
    public void checkUrl(String currentUrl) {
      String result =  WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(currentUrl, result);
    }
}