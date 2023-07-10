package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.datatable.DataTable;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import ru.egor.qa.selenidetest.interfaces.CommonInterfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract public class UiCommonSteps implements CommonInterfaces {
    private String fieldValue;


    public void dateFormatter(String dateFormat) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        String actualDate = dtf.format(LocalDate.now());
    }

    @Override
    public void dateMinus(String dateFormat, int value, String time, String locator) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        String beforeDate = null;
        switch (time) {
            case "день", "дня", "дней" -> beforeDate = dtf.format(LocalDate.now().minusDays(value));
            case "неделя", "недели", "недель" -> beforeDate = dtf.format(LocalDate.now().minusWeeks(value));
            case "месяц", "месяца", "месяцев" -> beforeDate = dtf.format(LocalDate.now().minusMonths(value));
            case "год", "года", "лет" -> beforeDate = dtf.format(LocalDate.now().minusYears(value));
        }

        if (locator.contains(".") | locator.contains("#")) {
            $(locator).sendKeys(beforeDate);
            return;
        }
        if (locator.contains("//")) {
            $x(locator).sendKeys(beforeDate);
            return;
        }
        $(By.name(locator)).sendKeys(beforeDate);
    }

    @Override
    public void datePlus(String dateFormat, int value, String time, String locator) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        String afterDate = null;
        switch (time) {
            case "день", "дня", "дней" -> afterDate = dtf.format(LocalDate.now().plusDays(value));
            case "неделя", "недели", "недель" -> afterDate = dtf.format(LocalDate.now().plusWeeks(value));
            case "месяц", "месяца", "месяцев" -> afterDate = dtf.format(LocalDate.now().plusMonths(value));
            case "год", "года", "лет" -> afterDate = dtf.format(LocalDate.now().plusYears(value));
        }

        if (locator.contains(".") | locator.contains("#")) {
            $(locator).sendKeys(afterDate);
            return;
        }
        if (locator.contains("//")) {
            $x(locator).sendKeys(afterDate);
            return;
        }
        $(By.name(locator)).sendKeys(afterDate);
    }

    public void cleanField(String locator) {
        if (locator.contains(".") | locator.contains("#")) {
            $(locator).clear();
            return;
        }
        if (locator.contains("//")) {
            $x(locator).clear();
            return;
        }
        $(By.name(locator)).clear();
    }

    @Override
    public void emptyField(String value) {
        boolean SearchFieldEmpty;

        if (value.contains(".") | value.contains("#")) {
            SearchFieldEmpty = $(value).val().isEmpty();
            return;
        }
        if (value.contains("//")) {
            SearchFieldEmpty = $x(value).val().isEmpty();
            return;
        }
        SearchFieldEmpty = $(By.name(value)).val().isEmpty();

        assertTrue(SearchFieldEmpty, "Поле поиска не пустое");
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
                return;
            }
            if (fieldName.contains("//")) {
                $x(fieldName).setValue(fieldValue);
                return;
            }
            $(By.name(fieldName)).setValue(fieldValue);
        }
    }

    @Override
    public void sortElement(@NotNull String fieldSelector, String key) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            $(fieldSelector).selectOptionByValue(key);
            return;
        }
        if (fieldSelector.contains("//")) {
            $x(fieldSelector).selectOptionByValue(key);
            return;
        }
        $(By.name(fieldSelector)).selectOptionByValue(key);
    }

    @Override
    public void checkQuantityPageElements(@NotNull String fieldSelector, int quantity) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            $$(fieldSelector).shouldHave(sizeGreaterThanOrEqual(quantity));
            return;
        }
        if (fieldSelector.contains("//")) {
            $$x(fieldSelector).shouldHave(sizeGreaterThanOrEqual(quantity));
            return;
        }
        $$(By.name(fieldSelector)).shouldHave(sizeGreaterThanOrEqual(quantity));
    }

    @Override
    public void rememberValue(@NotNull String fieldSelector) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            fieldValue = $(fieldSelector).getText();
            return;
        }
        if (fieldSelector.contains("//")) {
            fieldValue = $x(fieldSelector).getText();
            return;
        }
        fieldValue = $(By.name(fieldSelector)).getText();
    }

    @Override
    public void assertValue(String key) {
        Assertions.assertEquals(key, fieldValue);
    }

    @Override
    public void button(@NotNull String btnName) {
        if (btnName.contains(".") | btnName.contains("#")) {
            $(btnName).click();
            return;
        }
        if (btnName.contains("//")) {
            $x(btnName).click();
            return;
        }
        $(By.name(btnName)).click();
    }

    @Override
    public void enterValueIntTheField(@NotNull String fieldSelector, String value) {
        if (fieldSelector.contains(".") | fieldSelector.contains("#")) {
            $(fieldSelector).sendKeys(value);
            return;
        }
        if (fieldSelector.contains("//")) {
            $x(fieldSelector).sendKeys(value);
            return;
        }
        $(By.name(fieldSelector)).sendKeys(value);
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
        Configuration.browser = "chrome";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        open(url);
    }

    public void timeout(int params) throws InterruptedException {
        sleep(params);
    }
}
