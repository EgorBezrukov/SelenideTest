package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class SwagLabsStep extends ApplicationManager {


    /**
     * Описание шага: Позволяет по имени элемента подставить в поле передаваемое значение
     * <p>
     * Пример:
     * <pre>
     *         Когда пользователь вводит в поле "Логин" знчение "standard_user"
     *         И он вводит в поле "пароль" знчение "secret_sauce"
     * </pre>
     * @param fieldName  название поля элемента
     * @param fieldValue значение передаваемое в поле
     * </p>
     */
    @И("^(?:пользователь|он)? вводит в поле \"([^\"]*)\" знчение \"([^\"]*)\"$")
    public void input(String fieldName, String fieldValue) {
        enterLoginAndPassword(fieldName, fieldValue);
    }

    @И("^(?:пользователь|он)? проверяет что количество элементов на странице ровно \"([^\"]*)\"$")
    public void checkElementPage(int quantity) {
        checkQuantityPageElements(quantity);
    }

    @И("^(?:пользователь|он)? переходит на страницу рюкзака и запоминает значение цены$")
    public void openBackPackPage() {
        openBackPackAndRememberPrice();
    }

    @И("^(?:пользователь|он)? проверяет, что в корзине отображается колличесво товара \"([^\"]*)\"$")
    public void addToShoppingCart(int quantity) {
        addToShoppingCartAndAssert(quantity);
    }

    @Тогда("^(?:пользователь|он)? проверят сумму заказа$")
    public void checkSumOrder() {
        checkOrderSum();
    }


    @Когда("^(?:пользователь|он)? сортирует товары по цене от низкой к высокой$")
    public void sortsProductsByPriceFromLowToHigh() {
        sortByPriceLowHigh();
    }

    @Когда("^(?:пользователь|он)? сортирует товары по цене от высокой к низкой$")
    public void sortsProductsByPriceFromHighToLow() {
        sortByPriceHighLow();
    }

}