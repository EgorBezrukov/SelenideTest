package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.Selenide.$;

public class SwagLabsStep {

    private final ApplicationManager app = new ApplicationManager();

    @И("^(?:пользователь|он)? проверяет что количество элементов на странице ровно \"([^\"]*)\"$")
    public void checkElementPage(int quantity) {
        app.checkQuantityPageElements(quantity);
    }

    @И("^(?:пользователь|он)? переходит на страницу рюкзака и запоминает значение цены$")
    public void openBackPackPage() {
         app.openBackPackAndRememberPrice();
    }

    @И("^(?:пользователь|он)? проверяет, что в корзине отображается колличесво товара \"([^\"]*)\"$")
    public void addToShoppingCart(int quantity) {
        app.addToShoppingCartAndAssert(quantity);
    }

    @Тогда("^(?:пользователь|он)? проверят сумму заказа$")
    public void checkSumOrder() {
        app.checkOrderSum();
    }


    @Когда("^(?:пользователь|он)? сортирует товары по цене от низкой к высокой$")
    public void sortsProductsByPriceFromLowToHigh() {
        app.sortByPriceLowHigh();
    }

    @Когда("^(?:пользователь|он)? сортирует товары по цене от высокой к низкой")
    public void sortsProductsByPriceFromHighToLow() {
        app.sortByPriceHighLow();
    }

    @Тогда("^(?:пользователь|он)? проверяет, что отображается сообщение об ошибке \"([^\"]*)\"$")
    public void checkError(String massage) {
        app.checkErrorMassage(massage);
    }


}