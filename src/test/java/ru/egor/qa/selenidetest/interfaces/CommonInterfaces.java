package ru.egor.qa.selenidetest.interfaces;

/**
 * Интерфейс с описанием общих шагов проекта
 */

public interface CommonInterfaces {
    /**
     * Позволяет по имени элемента определить, в какое полле будет введен логин или пароль
     *
     * @param fieldName  название поля элемента
     * @param fieldValue значение передаваемое в поле
     */
    void enterLoginAndPassword(String fieldName, String fieldValue);

    /**
     * позволяет по имени элемента или с помощью css лементов нажать на кнопку
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
}
