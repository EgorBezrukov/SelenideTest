package ru.egor.qa.selenidetest.interfaces;

import io.cucumber.datatable.DataTable;

/**
 * Интерфейс с описанием общих шагов проекта
 */

public interface CommonInterfaces {

    /**
     * позволяет по имени элемента или с помощью css элементов нажать на кнопку
     *
     * @param btnName передаваемое значение поля элемента
     */
    void button(String btnName);

    /**
     * Сравнивает текущий url с передоваемым в параментрах
     *
     * @param currentUrl передаваемое значение url-a
     */
    void getUrlAndCheck(String currentUrl);

    /**
     * Before метод, настраивающий разрешение запускаемого окна и открывающий страницу из передаваемого значения
     *
     * @param url передаваемое значение url-a стартовой страницы
     */
    void openUrlAndConfigure(String url);

    /**
     * Позволяет по селектору поля подставить в него передаваемое значение
     *
     * @param fieldSelector селектор поля
     * @param value передаваемое значение поля элемента
     */
    void enterValueIntTheField(String fieldSelector, String value);

    /**
     * Позволяет по селектору поля получить его значение и сравнить с передаваемым значением
     *
     * @param fieldSelector селектор поля
     * @param value передаваемое значение поля элемента
     */
    void checkValueField(String fieldSelector, String value);

    /**
     * Позволяет по селектору поля получить его значение и сохранить его
     *
     * @param fieldSelector селектор поля
     */
    void rememberValue(String fieldSelector);

    /**
     * Позволяет сравнить значение с сохраненным ранее значением
     *
     * @param key ожидаемый результат
     */
    void assertValue(String key);

    /**
     * Позволяет сравнить колличесво элементов на страницы с ожидаемым результатом
     *
     * @param fieldSelector селектор элемта страницы
     * @param quantity ожидаемый результат для сравнения
     */
    void checkQuantityPageElements(String fieldSelector, int quantity);

    /**
     * Позволяет по селектору поля сортировки отсортировать элементы на страницы
     *
     * @param fieldSelector селектор поля
     * @param key ключ сортировки
     */
    void sortElement(String fieldSelector, String key);

    /**
     * Позволяет заполнять поля значениями используя табличную структуру
     *
     * @param dataTable таблица в которой передаются селекторы поля и передаваемое значение
     */
    void fillsFieldsValue(DataTable dataTable);

    /**
     * Позволяет переключиться на новую вкладку
     *
     * @param number номер вкладки
     */
    void newFrame(int number);
    /**
     * Позволяет включить ожидание
     *
     * @param milliseconds миллисекунды
     */
    void wait(int milliseconds);
}
