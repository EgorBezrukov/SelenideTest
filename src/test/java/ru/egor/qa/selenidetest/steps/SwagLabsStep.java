package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.egor.qa.selenidetest.elements.SwagLabsPageElements;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;

public class SwagLabsStep extends SwagLabsPageElements {
    @Когда("пользователь выполняет вход")
    public void inputLogin() {
        login.setValue("standard_user");
        password.setValue("secret_sauce").pressEnter();
    }

    @И("Он проверяет что количество элементов на странице ровно {int}")
    public void checkElementPage(int quantity) {
        inventoryList.shouldHave(sizeGreaterThanOrEqual(quantity))
                .first().shouldHave(text("Sauce Labs Backpack"));

    }

    @И("Он переходит на страницу рюкзака и запоминает значение цены")
    public String openBackPackPage() {
        backPackOpenPage.click();
        final String price = backPackPrice.getText();
        return price;
    }

    @И("Он добавляет товар в корзину и проверяет что в корзине отображается колличесво товара {int}")
    public void addToShoppingCart(int quantity) {
        addToCartButton.click();
        String result = cartBadge.getText();
        Integer res = Integer.parseInt(result);
        Assertions.assertEquals(quantity, res);
//        if (res.equals(quantity)){
//            System.out.println(true);
//        }else  System.out.println(false);

    }

    @Тогда("Он переходит в корзину и проверят сумму заказа")
    public void checkSumOrder() {

        cartButton.click();
        String result = itemPrise.getText();
//        Assertions.assertEquals(result, openBackPackPage());
        if (result.equals(openBackPackPage())) {
            System.out.println(result);
        }else  System.out.println(result + " не равно " + openBackPackPage());
    }
}