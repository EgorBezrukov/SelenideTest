package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import ru.egor.qa.selenidetest.elements.SwagLabsPageElements;

import static com.codeborne.selenide.Selenide.$;

public class ApplicationManager implements ru.egor.qa.selenidetest.interfaces.CommonInterfaces {
    private final SwagLabsPageElements sw = new SwagLabsPageElements();

    private String price;


    public void enterLoginAndPassword(String fieldName, String fieldValue) {
        String name;
        if (fieldName.equals("Логин")) name = "user-name";
        else name = "password";
        Selenide.$(By.name(name)).sendKeys(fieldValue);
    }

    @Override
    public void button(String btnName) {
        if (btnName.contains(".") | btnName.contains("#")) $(btnName).click();
        else $(By.name(btnName)).click();
    }
    @Override
    public void enterValueIntTheField(String field, String value) {
        if (field.contains(".") | field.contains("#")) $(field).sendKeys(value);
        else $(By.name(field)).sendKeys(value);
    }
    @Override
    public void checkValueField(String field, String value) {
        String result;
        if (field.contains(".") | field.contains("#"))  result = $(field).getText();
        else  result = $(By.name(field)).getText();
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

    public void checkErrorMassage(String massage) {
        String res = sw.getErrorMessage().getText();
        Assertions.assertEquals(res, massage);
    }

    public void checkQuantityPageElements(int quantity) {
        sw.getProductNames(quantity);
    }

    public void openBackPackAndRememberPrice() {
        price = sw.getBackPackPrice();
    }

    public void addToShoppingCartAndAssert(int quantity) {
        String result = sw.getCartBadge();
        Integer res = Integer.parseInt(result);
        Assertions.assertEquals(quantity, res);
    }

    public void checkOrderSum() {
        String result = sw.getItemPrise();
        if (result.equals(price)) {
            System.out.println(result);
        } else System.out.println(result + " не равно " + price);
    }

    public void sortByPriceLowHigh() {
        sw.getProductSortContainer().selectOptionByValue("lohi");
    }

    public void sortByPriceHighLow() {
        sw.getProductSortContainer().selectOptionByValue("hilo");
    }


}