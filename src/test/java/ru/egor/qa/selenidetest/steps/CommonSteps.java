package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

public class CommonSteps {

    private final ApplicationManager app = new ApplicationManager();

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
        app.enterLoginAndPassword(fieldName, fieldValue);
    }

    /**
     * Описание шага: позволяет по имени элемента или с помощью css элементов нажать на кнопку
     * <p>
     * Пример:
     *      <pre>
     *          И он нажимает на "login-button"
     *          И он нажимает на "#item_4_title_link"
     *          И он нажимает на ".shopping_cart_link"
     *     </pre>
     * @param btnName передаваемое значение поля элемента
     * </p>
     */
    @И("^(?:пользователь|он)? нажимает на \"([^\"]*)\"$")
    public void clickButton(String btnName) {
        app.button(btnName);
    }
    /**
     * Описание шага: Сравнивает текущий url с передоваемым в параментрах
     * <p>
     * Пример:
     *      <pre>
     *           Тогда пользователь проверяет что адрес сайта равен "https://www.saucedemo.com/inventory.html"
     *     </pre>
     * @param currentUrl передаваемое значение поля элемента
     * </p>
     */
    @Тогда("^(?:пользователь|он)? проверяет что адрес сайта равен \"([^\"]*)\"$")
    public void checkUrl(String currentUrl) {
        app.getUrlAndCheck(currentUrl);
    }

}