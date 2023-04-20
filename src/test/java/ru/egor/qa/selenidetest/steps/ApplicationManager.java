package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import ru.egor.qa.selenidetest.elements.SwagLabsPageElements;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;

public class ApplicationManager {
    private final SwagLabsPageElements sw = new SwagLabsPageElements();

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
        String res = sw.getErrorMessage().getText();
        Assertions.assertEquals(res, massage);
    }

    protected void checkQuantityPageElements(int quantity) {
        sw.getProductNames().shouldHave(sizeGreaterThanOrEqual(quantity));
    }

    protected String openBackPackAndRememberPrice() {
       final String price = sw.getBackPackPrice().getText();
        return price;
    }

    protected void addToShoppingCartAndAssert(int quantity) {
        String result = sw.getCartBadge().getText();
        Integer res = Integer.parseInt(result);
        Assertions.assertEquals(quantity, res);
    }

    protected void sortByPriceLowHigh() {
        sw.getProductSortContainer().selectOptionByValue("lohi");
    }

    protected void sortByPriceHighLow() {
        sw.getProductSortContainer().selectOptionByValue("hilo");
    }
}
