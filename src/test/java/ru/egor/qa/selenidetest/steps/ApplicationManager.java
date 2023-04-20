package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ApplicationManager {
    protected static void enterLoginAndPassword(String fieldName, String fieldValue) {
        String name;
        if (fieldName.equals("Логин")) name = "user-name";
        else name = "password";
        Selenide.$(By.name(name)).sendKeys(fieldValue);
    }

    protected static void button(String btnName) {
        if (btnName.contains(".") | btnName.contains("#")) $(btnName).click();
        else $(By.name(btnName)).click();
    }

    protected static void getUrlAndCheck(String currentUrl) {
        String result = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(currentUrl, result);
    }

    protected static void openUrlAndConfigure(String url) {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 60000;
        Selenide.open(url);
    }

    protected void checkErrorMassage(String massage) {
        String res = $("[data-test=error]").getText();
        Assertions.assertEquals(res, massage);
    }

    protected void checkQuantityPageElements(int quantity) {
        $$(".inventory_item_name").shouldHave(sizeGreaterThanOrEqual(quantity));
    }

    protected String openBackPackAndRememberPrice() {
        $("#item_4_title_link").click();
        String price = $(".inventory_details_price").getText();
        return price;
    }

    protected void addToShoppingCartAndAssert(int quantity) {
        $("#add-to-cart-sauce-labs-backpack").click();
        String result = $(".shopping_cart_badge").getText();
        Integer res = Integer.parseInt(result);
        Assertions.assertEquals(quantity, res);
    }

    protected void sortByPriceLowHigh() {
        $("select.product_sort_container").selectOptionByValue("lohi");
    }

    protected void sortByPriceHighLow() {
        $("select.product_sort_container").selectOptionByValue("hilo");
    }
}
