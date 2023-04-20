package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.Пусть;

public class BeforeStep extends ApplicationManager {

    @Пусть("^(?:пользователь|он)? открывает сайт \"([^\"]*)\"$")
    public void openSite(String url) {
        openUrlAndConfigure(url);
    }

}
