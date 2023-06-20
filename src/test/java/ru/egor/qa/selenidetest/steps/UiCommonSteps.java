package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.datatable.DataTable;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract public class UiCommonSteps implements ru.egor.qa.selenidetest.interfaces.CommonInterfaces {
    private String fieldValue;

    @Override
    public void emptyField(String value) {
        boolean isSearchFieldEmpty;
        if (value.contains(".") | value.contains("#")) {
            isSearchFieldEmpty = $(value).val().isEmpty();
        } else if (value.contains("//")) {
            isSearchFieldEmpty = $x(value).val().isEmpty();
        } else isSearchFieldEmpty = $(By.name(value)).val().isEmpty();

        assertTrue(isSearchFieldEmpty, "Поле поиска не пустое");
    }

    @Override
    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void newFrame(int number) {
        switchTo().window(number);
    }

    @Override
    public void fillsFieldsValue(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String fieldName = row.getOrDefault("Field", ""); // если значение не указано, используем пустую строку
            String fieldValue = row.getOrDefault("Key", ""); // если значение не указано, используем пустую строку
            if (fieldName.contains(".") | fieldName.contains("#")) {
                $(fieldName).setValue(fieldValue);
            } else if (fieldName.contains("//")) {
                $x(fieldName).setValue(fieldValue);
            } else $(By.name(fieldName)).setValue(fieldValue);
        }
    }

    @Override
    public void sortElement(@NotNull String fieldSelector, String key) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            $(fieldSelector).selectOptionByValue(key);
        } else if (fieldSelector.contains("//")) {
            $x(fieldSelector).selectOptionByValue(key);
        } else $(By.name(fieldSelector)).selectOptionByValue(key);
    }

    @Override
    public void checkQuantityPageElements(@NotNull String fieldSelector, int quantity) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            $$(fieldSelector).shouldHave(sizeGreaterThanOrEqual(quantity));
        } else if (fieldSelector.contains("//")) {
            $$x(fieldSelector).shouldHave(sizeGreaterThanOrEqual(quantity));
        } else $$(By.name(fieldSelector)).shouldHave(sizeGreaterThanOrEqual(quantity));
    }

    @Override
    public void rememberValue(@NotNull String fieldSelector) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            fieldValue = $(fieldSelector).getText();
        } else if (fieldSelector.contains("//")) {
            fieldValue = $x(fieldSelector).getText();
        } else fieldValue = $(By.name(fieldSelector)).getText();
    }

    @Override
    public void assertValue(String key) {
        Assertions.assertEquals(key, fieldValue);
    }

    @Override
    public void button(@NotNull String btnName) {
        if (btnName.contains(".") | btnName.contains("#")) {
            $(btnName).click();
        } else if (btnName.contains("//")) {
            $x(btnName).click();
        } else $(By.name(btnName)).click();
    }

    @Override
    public void enterValueIntTheField(@NotNull String fieldSelector, String value) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            $(fieldSelector).sendKeys(value);
        } else if (fieldSelector.contains("//")) {
            $x(fieldSelector).sendKeys(value);
        } else $(By.name(fieldSelector)).sendKeys(value);
    }

    @Override
    public void checkValueField(@NotNull String fieldSelector, String value) {
        String result;
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            result = $(fieldSelector).getText();
        } else result = $(By.name(fieldSelector)).getText();
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
        open(url);
    }
}
