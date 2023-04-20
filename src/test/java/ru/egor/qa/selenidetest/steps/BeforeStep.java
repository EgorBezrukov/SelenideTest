package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.Пусть;

public class BeforeStep extends ApplicationManager {
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

}
