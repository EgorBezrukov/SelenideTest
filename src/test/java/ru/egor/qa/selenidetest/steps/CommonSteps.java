package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

/**
 * Класс с общими шагами проекта
 */
public class CommonSteps {

    private final ApplicationManager app = new ApplicationManager();

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
    /**
     * Описание шага: Позволяет по селектору поля подставить в него передаваемое значение
     * <p>
     * Пример:
     *      <pre>
     *           И он заполняет поле "firstName" значением "Selenide"
     *           И он заполняет поле "#last-name" значением "Test"
     *           И он заполняет поле "postalCode" значением "0004"
     *     </pre>
     * @param field селектор поля
     * @param value передаваемое значение поля элемента
     * </p>
     */
    @И("^(?:поьзователь|он)? заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillingFields(String field, String value) {
        app.enterValueIntTheField(field, value);
    }
    /**
     * Описание шага: Позволяет по селектору поля получить его значение и сравнить с передаваемым значением
     * <p>
     * Пример:
     *      <pre>
     *          Тогда пользователь проверяет, что значение поля ".inventory_item_price" равно "$29.99"
     *     </pre>
     * @param field селектор поля
     * @param value передаваемое значение
     * </p>
     */
    @Тогда("^(?:пользователь|он)? проверяет, что значение поля \"([^\"]*)\" равно \"([^\"]*)\"$")
    public void checkValueFieldStep(String field, String value) {
        app.checkValueField(field, value);
    }

//    @И("^(?:пользователь|он)? запоминает значение поля \"([^\"]*)\" в переменную \"([^\"]*)\"$")

}