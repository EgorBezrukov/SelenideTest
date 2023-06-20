package ru.egor.qa.selenidetest.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;

/**
 * Класс с общими шагами проекта
 */
public class CommonSteps extends UiCommonSteps {
    /**
     * Описание шага: метод - предуслвие, настраивает разрешение запускаемого окна, устанавливает таймаут и открывает страницу из передаваемого значения
     * <p>
     * Пример:
     * <pre>
     *         Пусть пользователь открывает сайт "https://www.saucedemo.com/"
     * </pre>
     * @param url  url стартовой страницы
     * </p>
     */

    @Пусть("^(?:пользователь|он)? открывает сайт \"([^\"]*)\"$")
    public void openSite(String url) {
        openUrlAndConfigure(url);
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
     * @param btnSelector передаваемое значение поля элемента
     * </p>
     */
    @И("^(?:пользователь|он)? нажимает на \"([^\"]*)\"$")
    public void clickButton(String btnSelector) {
        button(btnSelector);
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
        getUrlAndCheck(currentUrl);
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
     * @param fieldSelector селектор поля
     * @param value передаваемое значение поля элемента
     * </p>
     */
    @И("^(?:пользователь|он)? заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillingFields(String fieldSelector, String value) {
        enterValueIntTheField(fieldSelector, value);
    }

    /**
     * Описание шага: Позволяет по селектору поля получить его значение и сравнить с передаваемым значением
     * <p>
     * Пример:
     *      <pre>
     *          Тогда пользователь проверяет, что значение поля ".inventory_item_price" равно "$29.99"
     *     </pre>
     * @param fieldSelector селектор поля
     * @param value передаваемое значение
     * </p>
     */
    @Тогда("^(?:пользователь|он)? проверяет, что значение поля \"([^\"]*)\" равно \"([^\"]*)\"$")
    public void checkValueFieldStep(String fieldSelector, String value) {
        checkValueField(fieldSelector, value);
    }

    /**
     * Описание шага: Позволяет сохранить значение поля
     * <p>
     * Пример:
     *      <pre>
     *           И пользователь запоминает значение поля ".inventory_item_price"
     *     </pre>
     * @param fieldSelector селектор поля
     * </p>
     */
   @И("^(?:пользователь|он)? запоминает значение поля \"([^\"]*)\"$")
    public void rememberElementValue(String fieldSelector){
        rememberValue(fieldSelector);
   }

    /**
     * Описание шага: Позволяет сравнить передаваемое значение с сохраненным
     * <p>
     * Пример:
     *      <pre>
     *           И пользователь проверяет что значение "$29" равно сохраненному знечению
     *     </pre>
     * @param value ожидаемый результат
     * </p>
     */
    @И("^(?:пользователь|он)? проверяет что значение \"([^\"]*)\" равно сохраненному знечению$")
    public void assertElementValue(String value){
        assertValue(value);
    }

    /**
     * Описание шага: Позволяет сравнить колличесво элементов на страницы с ожидаемым результатом
     *<p>
     * Пример:
     *      <pre>
     *           Тогда пользователь проверяет что количество элементов на странице ".inventory_item_name" ровно "6"
     *      </pre>
     * @param fieldSelector селектор элемта страницы
     * @param quantity ожидаемый результат для сравнения
     * </p>
     */
    @И("^(?:пользователь|он)? проверяет что количество элементов на странице \"([^\"]*)\" равно \"([^\"]*)\"$")
    public void checkElementPage(String fieldSelector, int quantity) {
        checkQuantityPageElements(fieldSelector,quantity);
    }
    /**
     * Описание шага: Позволяет отсортировать элементы страницы
     *<p>
     * Пример:
     *      <pre>
     *           Тогда пользователь сортирует элементы страницы ".product_sort_container" по параментру "hilo"
     *           Тогда пользователь сортирует элементы страницы ".product_sort_container" по параментру "lohi"
     *      </pre>
     * @param fieldSelector селектор элемта страницы
     * @param key ключ сортировки
     * </p>
     */
    @Когда("^(?:пользователь|он)? сортирует элементы страницы \"([^\"]*)\" по параментру \"([^\"]*)\"$")
    public void sortPageElement(String fieldSelector, String key) {
        sortElement(fieldSelector,key);
    }

    /**
     * Описание шага: Позволяет заполнять поля значениями используя табличную структуру
     *<p>
     * Пример:
     *      <pre>
     *       И он заполняет поля значениями:
     *       | Field      | Key      |
     *       | firstName  | Selenide |
     *       | lastName   | Test     |
     *       | postalCode | 606324   |
     *      </pre>
     * @param dataTable селектор элемта страницы
     * </p>
     */
    @Когда("^(?:пользователь|он)? заполняет (?:поля|форму)? значениями:$")
    public void fillFields(DataTable dataTable) {
            fillsFieldsValue(dataTable);
    }
    @Когда("^(?:пользователь|он)? открывает новую вкладку")
    public void openNewWindow(){
        newFrame();
    }
}