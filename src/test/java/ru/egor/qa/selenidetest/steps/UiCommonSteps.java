package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

abstract public class UiCommonSteps implements ru.egor.qa.selenidetest.interfaces.CommonInterfaces {
    private String fieldValue;

    @Override
    public void sortElement(String fieldSelector, String key) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) $(fieldSelector).selectOptionByValue(key);
        else if (fieldSelector.contains("//")) $x(fieldSelector).selectOptionByValue(key);
        else $(By.name(fieldSelector)).selectOptionByValue(key);
    }
    @Override
    public void checkQuantityPageElements(String fieldSelector, int quantity) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) $$(fieldSelector).shouldHave(sizeGreaterThanOrEqual(quantity));
        else if (fieldSelector.contains("//")) $$x(fieldSelector).shouldHave(sizeGreaterThanOrEqual(quantity));
        else $$(By.name(fieldSelector)).shouldHave(sizeGreaterThanOrEqual(quantity));
    }
    @Override
    public void rememberValue(String fieldSelector) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) fieldValue = $(fieldSelector).getText();
        else if (fieldSelector.contains("//")) fieldValue = $x(fieldSelector).getText();
        else fieldValue = $(By.name(fieldSelector)).getText();
    }
    @Override
    public void assertValue(String key) {
        Assertions.assertEquals(key, fieldValue);
    }

    @Override
    public void button(String btnName) {
        if (btnName.contains(".") | btnName.contains("#")) $(btnName).click();
        else if (btnName.contains("//")) $x(btnName).click();
        else $(By.name(btnName)).click();
    }

    @Override
    public void enterValueIntTheField(String fieldSelector, String value) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) $(fieldSelector).sendKeys(value);
        else if (fieldSelector.contains("//")) $x(fieldSelector).sendKeys(value);
        else $(By.name(fieldSelector)).sendKeys(value);
    }

    @Override
    public void checkValueField(String fieldSelector, String value) {
        String result;
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) result = $(fieldSelector).getText();
        else result = $(By.name(fieldSelector)).getText();
        Assertions.assertEquals(result, value);
    }

    @Override
    public void getUrlAndCheck(String currentUrl) {
        String result = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(currentUrl, result);
    }

    @Override
    public void openUrlAndConfigure(String url) {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        Selenide.open(url);
    }
}
