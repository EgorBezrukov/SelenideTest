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
     *         Пусть пользователь открывает страницу "https://www.saucedemo.com/"
     * </pre>
     *
     * @param url url стартовой страницы
     *            </p>
     */

    @Пусть("^(?:пользователь|он)? открывает страницу \"([^\"]*)\"$")
    public void openSite(String url) {
        openUrlAndConfigure(url);
    }

    /**
     * Описание шага: позволяет по имени элемента или с помощью css элементов нажать на кнопку
     * <p>
     * Пример:
     * <pre>
     *          И он нажимает на кнопку "login-button"
     *          И он нажимает на кнопку "#item_4_title_link"
     *          И он нажимает на кнопку ".shopping_cart_link"
     *     </pre>
     *
     * @param btnSelector передаваемое значение поля элемента
     *                    </p>
     */
    @И("^(?:пользователь|он)? нажимает на кнопку \"([^\"]*)\"$")
    public void clickButton(String btnSelector) {
        button(btnSelector);
    }

    /**
     * Описание шага: Сравнивает текущий url с передоваемым в параментрах
     * <p>
     * Пример:
     * <pre>
     *           Тогда пользователь проверяет что адрес страницы соответствует "https://www.saucedemo.com/inventory.html"
     *     </pre>
     *
     * @param currentUrl передаваемое значение поля элемента
     *                   </p>
     */
    @Тогда("^(?:пользователь|он)? проверяет что адрес страницы соответствует \"([^\"]*)\"$")
    public void checkUrl(String currentUrl) {
        getUrlAndCheck(currentUrl);
    }

    /**
     * Описание шага: Позволяет по селектору поля подставить в него передаваемое значение
     * <p>
     * Пример:
     * <pre>
     *           И он заполняет поле "firstName" значением "Selenide"
     *           И он заполняет поле "#last-name" значением "Test"
     *           И он заполняет поле "postalCode" значением "0004"
     *     </pre>
     *
     * @param fieldSelector селектор поля
     * @param value         передаваемое значение поля элемента
     *                      </p>
     */
    @И("^(?:пользователь|он)? заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillingFields(String fieldSelector, String value) {
        enterValueIntTheField(fieldSelector, value);
    }

    /**
     * Описание шага: Позволяет по селектору поля получить его значение и сравнить с передаваемым значением
     * <p>
     * Пример:
     * <pre>
     *          Тогда пользователь проверяет, что значение поля ".inventory_item_price" равно "$29.99"
     *     </pre>
     *
     * @param fieldSelector селектор поля
     * @param value         передаваемое значение
     *                      </p>
     */
    @Тогда("^(?:пользователь|он)? проверяет, что значение поля \"([^\"]*)\" равно \"([^\"]*)\"$")
    public void checkValueFieldStep(String fieldSelector, String value) {
        checkValueField(fieldSelector, value);
    }

    /**
     * Описание шага: Позволяет сохранить значение поля
     * <p>
     * Пример:
     * <pre>
     *           И пользователь запоминает значение поля ".inventory_item_price"
     *     </pre>
     *
     * @param fieldSelector селектор поля
     *                      </p>
     */
    @И("^(?:пользователь|он)? запоминает значение поля \"([^\"]*)\"$")
    public void rememberElementValue(String fieldSelector) {
        rememberValue(fieldSelector);
    }

    /**
     * Описание шага: Позволяет сравнить передаваемое значение с сохраненным
     * <p>
     * Пример:
     * <pre>
     *           И пользователь проверяет что значение "$29" равно сохраненному знечению
     *     </pre>
     *
     * @param value ожидаемый результат
     *              </p>
     */
    @И("^(?:пользователь|он)? проверяет что значение \"([^\"]*)\" равно сохраненному знечению$")
    public void assertElementValue(String value) {
        assertValue(value);
    }

    /**
     * Описание шага: Позволяет сравнить колличесво элементов на страницы с ожидаемым результатом
     * <p>
     * Пример:
     * <pre>
     *           Тогда пользователь проверяет что количество элементов на странице ".inventory_item_name" ровно "6"
     *      </pre>
     *
     * @param fieldSelector селектор элемта страницы
     * @param quantity      ожидаемый результат для сравнения
     *                      </p>
     */
    @И("^(?:пользователь|он)? проверяет что количество элементов на странице \"([^\"]*)\" равно \"([^\"]*)\"$")
    public void checkElementPage(String fieldSelector, int quantity) {
        checkQuantityPageElements(fieldSelector, quantity);
    }

    /**
     * Описание шага: Позволяет отсортировать элементы страницы
     * <p>
     * Пример:
     * <pre>
     *           Тогда пользователь сортирует элементы страницы ".product_sort_container" по параментру "hilo"
     *           Тогда пользователь сортирует элементы страницы ".product_sort_container" по параментру "lohi"
     *      </pre>
     *
     * @param fieldSelector селектор элемта страницы
     * @param key           ключ сортировки
     *                      </p>
     */
    @Когда("^(?:пользователь|он)? сортирует элементы страницы \"([^\"]*)\" по параментру \"([^\"]*)\"$")
    public void sortPageElement(String fieldSelector, String key) {
        sortElement(fieldSelector, key);
    }

    /**
     * Описание шага: Позволяет заполнять поля значениями используя табличную структуру
     * <p>
     * Пример:
     * <pre>
     *       И он заполняет поля значениями:
     *       | Field      | Key      |
     *       | firstName  | Selenide |
     *       | lastName   | Test     |
     *       | postalCode | 606324   |
     *      </pre>
     *
     * @param dataTable селектор элемта страницы
     *                  </p>
     */
    @Когда("^(?:пользователь|он)? заполняет (?:поля|форму)? значениями:$")
    public void fillFields(DataTable dataTable) {
        fillsFieldsValue(dataTable);
    }

    /**
     * Описание шага: Позволяет переключиться на новую вкладку
     * <p>
     * Пример:
     * <pre>
     *       И он открывает 1 вкладку
     *       И он открывает 2 вкладку
     *      </pre>
     *
     * @param number номер вкладки
     *               </p>
     */
    @Когда("^(?:пользователь|он)? открывает \"([^\"]*)\" вкладку$")
    public void openNewWindow(int number) {
        newFrame(number);
    }

    /**
     * Описание шага: Позволяет включить ожидание
     * <p>
     * Пример:
     * <pre>
     *      И он ожидает "5000" миллисекунд
     *      </pre>
     *
     * @param milliseconds миллисекунды
     *                     </p>
     */
    @Когда("^(?:пользователь|он)? ожидает \"([^\"]*)\" миллисекунд$")
    public void waitHelper(int milliseconds) {
        wait(milliseconds);
    }

    /**
     * Описание шага: Позволяет проверить поле ввода на пустоту
     * <p>
     * Пример:
     * <pre>
     *      Тогда он проверяет что поле "//input[@placeholder = 'Поиск']" пустое
     * </pre>
     *
     * @param value селектор поля ввода
     *              </p>
     */
    @Когда("^(?:пользователь|он)? проверяет что поле \"([^\"]*)\" пустое$")
    public void fieldIsEmpty(String value) {
        emptyField(value);
    }

    /**
     * Описание: Позволяет очистить поле
     * <p>
     * Пример:
     * </p>
     *
     * @param locator селектор поля
     */
    @Когда("^(?:пользователь|он)? очищает поле \"([^\"]*)\"$")
    public void fieldClear(String locator) {
        cleanField(locator);
    }

    /**
     * Описание: Позволяет вычесть из текущей даты дни, недели, месяцы, года
     * <p>
     * Пример:
     * </p>
     *
     * @param dateFormat формат даты (dd/MM/yyyy)
     * @param value единица времени
     * @param time период времени (день, неделя, месяц, год)
     * @param locator локатор поля
     */
    @Когда("^(?:пользователь|он)? из текущей даты формата \"([^\"]*)\" вычитает \"([^\"]*)\" \"([^\"]*)\" и подставляет в поле \"([^\"]*)\"$")
    public void dateFormatterMinusDate(String dateFormat, int value, String time, String locator) {
        dateMinus(dateFormat, value, time, locator);
    }

    /**
     * Описание: Позволяет прибавить к текущей дате дни, недели, месяцы, года
     * <p>
     * Пример:
     * </p>
     * @param dateFormat формат даты (dd/MM/yyyy)
     * @param value единица времени
     * @param time период времени (день, неделя, месяц, год)
     * @param locator локатор поля
     */
    @Когда("^(?:пользователь|он)? прибавляет к текущей дате формата \"([^\"]*)\" вычитает \"([^\"]*)\" \"([^\"]*)\" и подставляет в поле \"([^\"]*)\"$")
    public void dateFormatterPlusDate(String dateFormat, int value, String time, String locator) {
        dateMinus(dateFormat, value, time, locator);
    }
}