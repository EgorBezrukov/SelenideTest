package ru.egor.qa.selenidetest.interfaces;

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
     *@param field селектор поля
     *@param value передаваемое значение поля элемента
     */
    void enterValueIntTheField(String field, String value);
    /**
     * Позволяет по селектору поля получить его значение и сравнить с передаваемым значением
     *
     * @param field селектор поля
     * @param value передаваемое значение поля элемента
     */
    void checkValueField(String field, String value);
}
